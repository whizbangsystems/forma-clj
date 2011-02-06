(ns forma.core
  (:use cascalog.api
        (forma [sources :only (all-files)]
               conversion))
    (:require (cascalog [vars :as v]
                        [ops :as c])
            (forma [hdf :as h]
                   [rain :as r])))

(def forma-subsets
  ^{:doc "MODIS datasets required for FORMA processing."}
  #{:ndvi :evi :qual :reli})

(def forma-res "1000")

;; ## Test Queries

;; TODO -- comment here on why we don't split this up into a
;; subquery. it's because the FORMA datasets themselves can't actually
;; be serialized over Hadoop, as no serializer can be registered. As
;; such, first we need to convert them into some sort of serializable
;; int array, plus associated metadata. This query (must be renamed)
;; will return the data array, plus all metadata that we'll want over
;; the course of the calculations.

;; TODO --some research on cascalog and cascading to see how we do a
;; join of data; we want a query that will give us absolutely all of
;; the chunks, for any dataset we like.

;;  If this query works, almost all steps along the way also work --
;;  though, as of now, we do have the possibility that we'll have some
;;  error on the step where we read the raster into the array.

(defn chunk-test
  "Simple query that takes a directory containing MODIS HDF files, or
  a link directly to such a file, totals up the # of chunks per file,
  and displays the count alongside some other nice metadata."
  [dir]
  (let [source (all-files dir)
        chunks (h/modis-chunks source forma-subsets)]
    (?<- (stdout)
         [?dataset ?res ?tile-x ?tile-y ?period ?count]
         (chunks ?dataset ?res ?tile-x ?tile-y ?period ?chunkid ?chunk)
         (c/count ?count))))

(defmapop [extract-period [res]]
  ^{:doc "Extracts ."}
  [filename month]
  (let [year (Integer/parseInt (first (re-find #"(\d{4})" filename)))]
    (julian->period year month res)))

;; This has some fundamental errors. For example, what do we do for
;; rain data when we start getting in to higher resolution MODIS?
;; We're going to have all of these gaps in the periods.

(defn rain-months
  "Test query! Returns redundant filenames, and a month variable
  corresponding to each rain dataset within the supplied directory."
  ([rain-dir]
     (rain-months rain-dir forma-res))
  ([rain-dir res]
     (let [rain-files (all-files rain-dir)]
       (?<- (stdout) [?dataset ?res ?period]
            (rain-files ?filename ?file)
            (extract-period [res] ?filename ?month :> ?period)
            (r/unpack-rain ?file :> ?dataset ?month ?month-data)))))