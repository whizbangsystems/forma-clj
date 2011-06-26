(ns forma.source.fire-test
  (:use [forma.source.fire] :reload)
  (:use cascalog.api
        midje.sweet)
  (:require [forma.testing :as t]))

;; TODO: Remove some of the data from this path.
(def daily-fires-path
  (t/dev-path "/testdata/FireDaily/MCD14DL.2011074.txt"))

;; TODO: Remove some of the data from this path.
(def monthly-fires-path
  (t/dev-path "/testdata/FireMonthly/MCD14ML.200011.005.01.asc.gz"))

;; TODO: Update test and tap to reference new fires information.
;; TODO: Add daily and monthly fires to dev/testdata.

;; TODO: Remove this test tap!
(def new-fire-tap
  (memory-source-tap
   [["-4.214,152.190,319.9,1.6,1.2,06/15/2010,0035,T,0,5.0,301.3,27.8"]
   ["-26.464,148.237,312.2,1.7,1.3,06/15/2010,0040,T,30,5.0,288.3,16.9"]
   ["-28.314,150.342,329.3,2.5,1.5,06/15/2010,0040,T,82,5.0,301.9,83.4"]
   ["-27.766,140.252,317.3,1.1,1.0,06/15/2010,0040,T,63,5.0,305.8,15.4"]
   ["-29.059,150.453,331.3,2.6,1.6,06/15/2010,0040,T,84,5.0,302.4,91.2"]
   ["-29.059,150.453,331.3,2.6,1.6,06/16/2010,0040,T,84,5.0,302.4,91.2"]
   ["-29.059,150.453,331.3,2.6,1.6,06/17/2010,0040,T,84,5.0,302.4,91.2"]
   ["-29.059,150.453,331.3,2.6,1.6,08/18/2010,0040,T,84,5.0,302.4,91.2"]
   ["-29.063,150.447,327.3,2.6,1.6,09/15/2010,0040,T,80,5.0,301.9,67.0"]
   ["-28.963,148.843,322.2,2.0,1.4,10/15/2010,0040,T,75,5.0,302.9,26.5"]
   ["-28.971,148.801,329.4,2.0,1.4,11/15/2010,0040,T,82,5.0,303.2,51.0"]
   ["-28.975,148.842,328.7,2.0,1.4,12/15/2010,0040,T,82,5.0,303.2,50.5"]
   ["-29.262,150.233,328.2,2.5,1.5,12/15/2010,0040,T,81,5.0,301.1,64.9"]]))

(defn run-rip
  "Rips apart fires!"
  [t-res start end]
  (?- (stdout)
      (->> new-fire-tap
           (reproject-fires "1000")
           (aggregate-fires t-res)
           (fire-series t-res start end))))
