(ns puzzle.core
  (:gen-class)
  (:require [puzzle.support-functions :refer :all]))

;; https://adventofcode.com/
;; (c) Eric Uitbeijerse
;; Dec 2021

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
  
  (puzzlePart1 (loadData "resources/puzzleTestInput.txt"))
  (puzzlePart1 (loadData "resources/puzzleInput.txt"))

  (puzzlePart2 (loadData "resources/puzzleTestInput.txt"))
  (puzzlePart2 (loadData "resources/puzzleInput.txt"))
 
    
  )