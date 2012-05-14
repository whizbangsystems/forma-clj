(ns forma.schema
  (:require [forma.date-time :as date]
            [forma.reproject :as r]
            [forma.utils :as u]            
            [clojure.string :as s])
  (:import [forma.schema
            ArrayValue
            DataChunk
            DataValue
            DoubleArray
            FireSeries
            FireTuple
            FormaSeries
            FormaValue
            IntArray
            LocationProperty
            LocationPropertyValue
            LongArray
            ModisChunkLocation
            ModisPixelLocation
            NeighborValue
            NeighborValue
            ShortArray
            TimeSeries]
           [org.apache.thrift TBase]
           [java.util ArrayList]))

(defprotocol Thrifster
  (unpack [this keys])
  (t-keys [this])
  (t-val [this key]))

(defprotocol TBone
  (field-id [this key metaDataMap])
  (field-keys [this metaDataMap])
  (field-map [this metaDataMap])
  (field-names [this metaDataMap])
  (field-value [this key metaDataMap]))

(extend-type TBase
  TBone 
  (field-id [this key metaDataMap]
    "Returns the Thrift field id for a given key."
    (.getThriftFieldId ((field-map this metaDataMap) key)))  
  (field-keys [this metaDataMap]
    "Returns all field name keys."
    (map keyword (map #(.getFieldName %) (keys metaDataMap))))
  (field-map [this metaDataMap]
    "Returns a mapping of field name keys to fields."
    (zipmap
     (field-keys this metaDataMap)
     (keys metaDataMap)))
  (field-names [this metaDataMap]
    "Returns a vector of field names."
    (map #(.getFieldName %) (keys metaDataMap)))  
  (field-value [this key metaDataMap]
    "Returns the Thrift value for the given key."
    (.getFieldValue this ((field-map this metaDataMap) key))))

(extend-type FireTuple
  Thrifster
  (unpack [this keys]
    "Returns a vector of Thrift values in the order specified by keys."
    (map #(field-value this % FireTuple/metaDataMap) keys))    
  (t-keys [this]
    "Returns all field name keys."
    (field-keys this FireTuple/metaDataMap))
  (t-val [this key]
    "Returns the Thrift value for the given key."
    (field-value this key FireTuple/metaDataMap)))


;; (extend-type FireTuple

;;   Thrifster

;;   (unpack [this keys]
;;     "Returns a vector of Thrift values in the order specified by keys."
;;     (map #(field-value this %) keys))
    
;;   (field-id [this key]
;;     "Returns the Thrift field id for a given key."
;;     (.getThriftFieldId ((field-map this) key)))
  
;;   (field-keys [this]
;;     "Returns all field name keys."
;;     (map keyword (map #(.getFieldName %) (keys (FireTuple/metaDataMap)))))

;;   (field-map [this]
;;     "Returns a mapping of field name keys to fields."
;;     (zipmap
;;      (field-keys this)
;;      (keys (FireTuple/metaDataMap))))

;;   (field-names [this]
;;     "Returns a vector of field names."
;;     (map #(.getFieldName %) (keys (FireTuple/metaDataMap))))
  
;;   (field-value [this key]
;;     "Returns the Thrift value for the given key."
;;     (.getFieldValue this ((field-map this) key))))

(defn boundaries
  "Accepts a sequence of pairs of <initial time period, collection>
  and returns the maximum start period and the minimum end period. For
  example:

    (boundaries [0 [1 2 3 4] 1 [2 3 4 5]]) => [1 4]"
  [pair-seq]
  {:pre [(even? (count pair-seq))]}
  (reduce (fn [[lo hi] [x0 ct]]
            [(max lo x0) (min hi ct)])
          (for [[x0 seq] (partition 2 pair-seq)]
            [x0 (+ x0 (count seq))])))

(defn adjust
  "Appropriately truncates the incoming timeseries values (paired with
  the initial integer period), and outputs a new start and both
  truncated series. For example:

    (adjust 0 [1 2 3 4] 1 [2 3 4 5])
    ;=> (1 [2 3 4] [2 3 4])"
  [& pairs]
  {:pre [(even? (count pairs))]}
  (let [[bottom top] (boundaries pairs)]
    (cons bottom
          (for [[x0 seq] (partition 2 pairs)]
            (into [] (u/trim-seq bottom top x0 seq))))))

;; ## Time Series

(defn timeseries-value
  "Takes a period index > 0 `start-idx` and a time series `series`,
 outputs same plus `end-idx` calculated by counting the number of
 elements in `series`.

    (timeseries-value 0 [1 2 3])
    ;=> {:start-idx 0
         :end-idx 2
         :series [1 2 3]}"
  ([start-idx series]
     (let [elems (count series)]
       (timeseries-value start-idx
                         (dec (+ start-idx elems))
                         series)))
  ([start-idx end-idx series]
     (when (seq series)
       {:start-idx start-idx
        :end-idx   end-idx
        :series    (vec series)})))

(defrecord TimeSeriesValue [start-idx end-idx series])

(defn ts-record
  ([start-idx series]
     (let [elems (count series)]
       (ts-record start-idx
                  (dec (+ start-idx elems))
                  series)))
  ([start-idx end-idx series]
     (when-let [series-vec (not-empty (vec series))]
       (TimeSeriesValue. start-idx end-idx series-vec))))

(defn adjust-timeseries
  "Takes in any number of timeseries objects, and returns a new
  sequence of appropriately truncated TimeSeries objects generated
  from the temporal overlap of the input timeseries objects.

   (schema/adjust-timeseries (schema/timeseries-value 0 [1 2 3])
                             (schema/timeseries-value 1 [1 2 3 4]))
   ;=> [{:start-idx 1,
         :end-idx 2,
         :series [2 3]}
        {:start-idx 1,
         :end-idx 2,
         :series [1 2]}]"
  [& tseries]
  (let [[start & ts-seq] (->> tseries
                              (mapcat (juxt :start-idx :series))
                              (apply adjust))]
    (map (partial ts-record start)
         ts-seq)))

;; ### Fire Values

(def example-fire-value
  {:temp-330   "number of fires w/ (> T 330 degrees Kelvin)"
   :conf-50    "number of fires w/ confidence above 50."
   :both-preds "number of fires w/ both."
   :count      "number of fires on the given day."})

;; Record to hold a FireValue.
(defrecord FireValue [temp-330 conf-50 both-preds count])

(defn fire-value
  "Creates a `fire-value` object with counts of fires meeting certain criteria:
    temp >= 330
    confidence >= 50
    both temp and confidence
    total fires

    (schema/fire-value 1 0 3 4)
    ;=> {:temp-330 1, :conf-50 0, :both-preds 3, :count 4}"
  [t-above-330 c-above-50 both-preds count]
  {:temp-330 t-above-330
   :conf-50 c-above-50
   :both-preds both-preds
   :count count})

(defn add-fires
  "Returns a new `fire-value` object generated by summing up the fields
  of each of the supplied `fire-value` objects.

    (schema/add-fires
     {:temp-330 1, :conf-50 0, :both-preds 3, :count 4}
     {:temp-330 1, :conf-50 0, :both-preds 3, :count 4})
    ;=> {:count 8, :conf-50 0, :temp-330 2, :both-preds 6}" 
  [& f-tuples]
  (apply merge-with + f-tuples))

(defn adjust-fires
  "Returns the section of fires data found appropriate based on the
  information in the estimation parameter map.

    (let [est-map {:est-start \"2005-12-01\"
                   :est-end \"2011-04-01\"
                   :t-res \"32\"
                   :neighbors 1
                   :window-dims [600 600]
                   :vcf-limit 25
                   :long-block 15
                   :window 5}
          f-series []]
    ;=> (adjust-fires est-map f-series)"
  ;; TODO: add a sample f-series, result
  [{:keys [est-start est-end t-res]} f-series]
  (let [[start end] (for [pd [est-start est-end]]
                      (date/datetime->period t-res pd))]
    [(->> (:series f-series)
          (map map->FireValue)
          (u/trim-seq start (inc end) (:start-idx f-series))
          (ts-record start))]))

;; # Compound Objects

(def example-forma-value
  {:fire-value  "fire value."
   :param-break "Arbitrary name for the amount of downward wiggle in the timeseries."
   :short-drop  "Short term drop in NDVI."
   :long-drop   "Long term drop in NDVI."
   :t-stat      "t-statistic for the relevant month."})

(defrecord FormaValue
    [fire-value short-drop param-break long-drop t-stat])

(defn forma-value
  "Returns a vector containing a FireValue, short-term drop,
  parametrized break, long-term drop and t-stat of the short-term
  drop."
  [fire short param-break long t-stat]
  (let [fire (or fire (FireValue. 0 0 0 0))]
    [fire short param-break long t-stat]))

;; ## Neighbor Values

(defrecord NeighborValue
    [fire-value neighbor-count avg-short-drop min-short-drop
     avg-param-break min-param-break avg-long-drop min-long-drop
     avg-t-stat min-t-stat])

(defn neighbor-value
  "Accepts either a forma value or a sequence of sub-values."
  ;; TODO: come up with an example
  ([[fire short param long t-stat]]
     (NeighborValue. fire 1 short short param param long long t-stat t-stat))
  ([fire neighbors avg-short
    min-short avg-param min-param avg-long min-long avg-stat min-stat]
     (NeighborValue.
      fire neighbors avg-short min-short avg-param
      min-param avg-long min-long avg-stat min-stat)))

(defn unpack-neighbor-val
  "Returns a vector containing the fields of a forma-neighbor-value."
  [neighbor-val]
  (map (partial get neighbor-val)
       [:fire-value :neighbor-count
        :avg-short-drop :min-short-drop
        :avg-param-break :min-param-break
        :avg-long-drop :min-long-drop
        :avg-t-stat :min-t-stat]))

(defn merge-neighbors
  "Merges the supplied instance of `FormaValue` into the existing
  aggregate collection of `FormaValue`s represented by
  `neighbor-val`. (`neighbors` must be an instance of
  neighbor-value)"
  ;; TODO: come up with an example
  [neighbors forma-val]
  (let [n-count  (:neighbor-count neighbors)
        [fire short param long t-stat] forma-val]
    (prn neighbors ", " [fire short param long t-stat])
    (-> neighbors
        (update-in [:fire-value]     add-fires fire)
        (update-in [:neighbor-count] inc)
        ;; (update-in [:avg-short-drop] u/weighted-mean n-count short 1)
        ;; (update-in [:avg-param-break] u/weighted-mean n-count param 1)
        ;; (update-in [:avg-long-drop]  u/weighted-mean n-count long 1)
        ;; (update-in [:avg-t-stat]     u/weighted-mean n-count t-stat 1)
        (update-in [:min-short-drop] min short)
        (update-in [:min-param-break] min param)
        (update-in [:min-long-drop]  min long)
        (update-in [:min-t-stat]     min t-stat))))

(defn combine-neighbors
  "Returns a new forma neighbor value generated by merging together
   each entry in the supplied sequence of forma values."
  ;; TODO: come up with an example
  [[x & more]]
  (if x
    (reduce merge-neighbors (neighbor-value x) more)
    (neighbor-value (FireValue. 0 0 0 0) 0 0 0 0 0 0 0 0 0)))

;; ## Location

(def example-chunk-location
  {:spatial-res "Spatial resolution (modis)"
   :mod-h "horizontal modis coordinate."
   :mod-v "Vertical modis coordinate."
   :index "Chunk index within the modis tile."
   :size  "Number of pixels in the chunk."})

(defn chunk-location
  "Creates a chunk-location object.

    (chunk-location \"1000\" 28 9 59 24000)
    ;=> {:spatial-res \"1000\", :mod-h 28, :mod-v 9, :index 59, :size 24000}"
  [spatial-res mod-h mod-v idx size]
  {:spatial-res spatial-res
   :mod-h       mod-h
   :mod-v       mod-v
   :index       idx
   :size        size})

(def example-pixel-location
  {:spatial-res "Spatial resolution (modis)"
   :mod-h "horizontal modis coordinate."
   :mod-v "Vertical modis coordinate."
   :sample "Sample (column) within modis tile."
   :line  "Line (row) within modis tile."})

(defn pixel-location
  "Creates a pixel-location object.

    (pixel-location \"1000\" 28 9 1199 10)
    ;=> {:spatial-res \"1000\", :mod-h 28, :mod-v 9, :sample 1199, :line 10}"
  [spatial-res mod-h mod-v sample line]
  {:spatial-res spatial-res
   :mod-h       mod-h
   :mod-v       mod-v
   :sample      sample
   :line        line})

(defn unpack-pixel-location
  "Unpacks pixel-location object into a tuple.

    (unpack-pixel-location
     {:spatial-res \"1000\", :mod-h 28, :mod-v 9, :sample 1199, :line 10})
    ;=> [\"1000\" 28 9 1199 10]"
  [loc]
  (map loc [:spatial-res :mod-h :mod-v :sample :line]))

(defn unpack-chunk-location
  "Unpacks chunk-location object into a tuple.

    (unpack-chunk-location
     {:spatial-res \"1000\", :mod-h 28, :mod-v 9, :index 4, :size 24000})
    ;=> [\"1000\" 28 9 4 24000]"
  [loc]
  (map loc [:spatial-res :mod-h :mod-v :index :size]))

(defn chunkloc->pixloc
  "Accepts a chunk location and a pixel index within that location and
   returns a pixel location.
 
     (chunkloc->pixloc
      {:spatial-res \"1000\", :mod-h 28, :mod-v 9, :index 59, :size 24000}
      23999)

    ;=> {:spatial-res \"1000\", :mod-h 28, :mod-v 9, :sample 1199, :line 1199}"
  [{:keys [spatial-res size index mod-h mod-v]} pix-idx]
  (apply pixel-location spatial-res mod-h mod-v
         (r/tile-position spatial-res size index pix-idx)))

;; ## Data Chunks

(defn chunk-value
  "Creates a chunk-value object.

   Example:
    (let [size 24000
          location (chunk-location \"1000\" 8 6 0 24000)
          data (range size)]
     (chunk-value \"ndvi\" \"32\" \"2006-01-01\" location (take 10 data))

  ;=> {:date \"2006-01-01\"
       :temporal-res \"32\"
       :location {:spatial-res \"1000\", :mod-h 8, :mod-v 6, :index 0, :size 24000}     :dataset \"ndvi\"
       :value [0 1 2 3 4 5 6 7 8 9]}"
  [dataset t-res date location data-value]
  {:temporal-res t-res
   :location     location
   :dataset      dataset
   :value        data-value
   :date         date})

(defn unpack-chunk-val
  "Used by timeseries. Unpacks a chunk object. Returns `[dataset-name
 t-res date location collection]`, where collection is a vector and
 location is a `chunk-location`.

   Example:

  (schema/unpack-chunk-val {:date \"2006-01-01\"
                            :temporal-res \"32\"
                            :location {:spatial-res \"1000\"
                                       :mod-h 8
                                       :mod-v 6
                                       :index 0
                                       :size 24000}
                            :dataset \"ndvi\"
                            :value [0 1 2 3 4 5 6 7 8 9]})   
  ;=> [\"ndvi\" \"32\" \"2006-01-01\" {:mod-h 8, :size 24000, :mod-v 6, :spatial-res \"1000\", :index 0} [0 1 2 3 4 5 6 7 8 9]"
  [chunk]
  (map chunk [:dataset :temporal-res :date :location :value]))

(defn forma-seq
  "Accepts a number of timeseries of equal length and starting
  position, and converts the first entry in each timeseries to a forma
  value, for all first values and on up the sequence. Series must be
  supplied as specified by the arguments for `forma-value`. For
  example:

    (forma-seq fire-series short-series long-series t-stat-series)"
  [& in-series]
  [(->> in-series
        (map #(or % (repeat %)))
        (apply map forma-value))])
