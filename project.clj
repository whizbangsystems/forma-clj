(defproject forma "0.1.0-SNAPSHOT"
  :description "[FORMA](http://goo.gl/4YTBw) gone Functional."
  :source-path "src/clj"
  :java-source-path "src/jvm"
  :warn-on-reflection true
  :marginalia {:javascript ["mathjax/MathJax.js"]}
  :javac-options {:debug "true" :fork "true"}
  :repositories {"conjars" "http://conjars.org/repo/"
                 "sonatype" "http://oss.sonatype.org/content/repositories/releases"}
  :tasks [cake-pallet.tasks]
  :dependencies [[org.clojure/clojure "1.2.0"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [incanter "1.2.3"]
                 [cascalog "1.7.0-SNAPSHOT"]
                 [clj-time "0.3.0-SNAPSHOT"]
                 [org.cloudhoist/pallet "0.4.3"]
                 [org.cloudhoist/pallet-crates-standalone "0.4.0"]
                 [org.jclouds/jclouds-all "1.0-beta-8"]
                 [org.clojars.sritchie09/gdal-java-native "1.8.0"]]
  :dev-dependencies [[org.apache.hadoop/hadoop-core "0.20.2-dev"]
                     [swank-clojure "1.2.1"]
                     [cake-pallet "0.4.0"]
                     [marginalia "0.5.0"]
                     [midje "1.0.1"]])