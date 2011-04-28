(ns forma.source.fire-test
  (:use forma.source.fire
        cascalog.api
        midje.sweet))

(def fire-tap
  (memory-source-tap
   [["-4.214,152.190,319.9,1.6,1.2,03/15/2011,0035,T,0,5.0,301.3,27.8"]
   ["-26.464,148.237,312.2,1.7,1.3,03/15/2011,0040,T,30,5.0,288.3,16.9"]
   ["-28.314,150.342,329.3,2.5,1.5,03/15/2011,0040,T,82,5.0,301.9,83.4"]
   ["-27.766,140.252,317.3,1.1,1.0,03/15/2011,0040,T,63,5.0,305.8,15.4"]
   ["-29.059,150.453,331.3,2.6,1.6,03/15/2011,0040,T,84,5.0,302.4,91.2"]
   ["-29.063,150.447,327.3,2.6,1.6,03/15/2011,0040,T,80,5.0,301.9,67.0"]
   ["-28.963,148.843,322.2,2.0,1.4,03/15/2011,0040,T,75,5.0,302.9,26.5"]
   ["-28.971,148.801,329.4,2.0,1.4,03/15/2011,0040,T,82,5.0,303.2,51.0"]
   ["-28.975,148.842,328.7,2.0,1.4,03/15/2011,0040,T,82,5.0,303.2,50.5"]
   ["-29.262,150.233,328.2,2.5,1.5,03/15/2011,0040,T,81,5.0,301.1,64.9"]
   ["-29.254,150.228,321.9,2.5,1.5,03/15/2011,0040,T,75,5.0,300.7,32.6"]
   ["-30.767,147.829,323.6,1.8,1.3,03/15/2011,0040,T,77,5.0,302.7,28.3"]]))
