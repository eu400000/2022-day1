(ns puzzle.support-functions
  (:require [clojure.string :as str]))

(defn loadData
  [inputFileName]
  (slurp inputFileName))

(defn process [data]
  (let [split (str/split data #"\r\n")
        convert (map #(Integer/parseInt %) split)]
    convert))

(defn parse-data [data]
  (let [parse-by-elf (re-seq #"(?ms)[0-9\r\n]+?\r\n\r\n" (str data "\r\n\r\n"))
        processed-elves (map #(process %1) parse-by-elf)
        ]
    processed-elves))


(comment
    
  (def d1 (str (slurp "resources/puzzleTestInput.txt") "\r\n\r\n"))
  (parse-data d1)
  
 )
