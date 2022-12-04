(ns day1.core
  (:gen-class)
  (:require [clojure.string :as str]))

;; https://adventofcode.com/
;; (c) Eric Uitbeijerse
;; Dec 2021


(defn loadData
  [inputFileName]
  (slurp inputFileName))

(defn process [data]
  (let [split (str/split data #"\r\n")
        convert (map #(Integer/parseInt %) split)]
    convert))

(defn parse-data [data]
  (let [parse-by-elf (re-seq #"(?ms)[0-9\r\n]+?\r\n\r\n" (str data "\r\n\r\n"))
        processed-elves (map #(process %1) parse-by-elf)]
    processed-elves))


(comment

  (def d1 (str (slurp "input.txt") "\r\n\r\n"))
  (parse-data d1))



(defn puzzlePart1 [PuzzleData]
  (let [data (parse-data PuzzleData)
        sum (map #(reduce (fn [a,v] (+ a v)) %1) data)]
    (println data sum)
    (apply max sum)))

(defn puzzlePart2 [PuzzleData]
  (let [data (parse-data PuzzleData)
        sum (sort > (map #(reduce (fn [a,v] (+ a v)) %1) data))]
    (println data sum)
    (reduce #(+ %1 %2) (take 3 sum))))


(comment
  
  (puzzlePart1 (loadData "day1/src/test-input.txt"))
  (puzzlePart1 (loadData "day1/src/Input.txt"))

  (puzzlePart2 (loadData "day1/src/test-input.txt"))
  (puzzlePart2 (loadData "day1/src/input.txt"))
 
    
  )