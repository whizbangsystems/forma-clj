(ns forma.hadoop.cli
  "CLI for managing and manipulating FORMA's operations on the Hadoop
  cluster."
  (:use [clojure.tools.cli]
        [clojure.data.json :only (json-str write-json read-json)])
  (:require [clojure.java.io :as io]
            [clojure.tools.cli :as cli]))

;; FORMA operations.
(def operations ["process-modis", "process-fires", "process-rain"])

(defn parse-cli
  "Parses a command line sequence and returns a vector containing three
  elements. The first item is a map of options. The second item is a vector of
  trailing arguments. The third item is a documentation string to provide usage."
  [command]
  (cli command
       ["-h" "--help" "Show this help message." :default true :flag true]
       ["-l" "--list-operations" "List FORMA operations." :flag true]))

(defn get-config
  "Returns a map of configuration options given a path to a JSON config file,
  or nil if there is a problem with the file."
  [file-path]
  (let [file (io/as-file (io/resource file-path))]
    (if (nil? file)
      (prn (format "Problem with file %s" file-path))
      (read-json (slurp file)))))

(defn execute-op
  "Executes an operation using parameters in the configuration file."
  [op config-file-path]
  (let [config (get-config config-file-path)]
    ;; TODO: Execute operation.
    (if (nil? config)
      (prn (format "Failed to execute operation %s" op))
      (prn (format "Operation: %s, Config: %s" op config)))))

(defn -main
  "CLI entry point. It's wired up to read config files in the /dev directory.

  > (-main {operation-name} {config-filename})

  For usage help:
    > (-main \"-h\")
  "    
  [& command]
  (let [[options trailing banner] (parse-cli command)]
    (cond
     (:help options) (prn banner)
     (:list-operations options) (prn (format "Operations: %s" operations))
     (not (= (count trailing) 2)) (prn "Missing operation or config file.")
     :else (let [[operation config-file-path] trailing]
             (if (not-any? #(= % operation) operations)
               (prn (format "Unknown operation %s" operation))
               (execute-op operation config-file-path))))))


