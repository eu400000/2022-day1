(ns puzzle.core-test
  (:require [clojure.test :refer :all]
            [puzzle.core :refer :all]))

(def puzzleTestData '(1000
2000
3000

4000

5000
6000

7000
8000
9000

10000))

(deftest puzzlePart1-test
  (is (= 24000 (puzzlePart1 puzzleTestData))))

;; (deftest day3Part2-test
;;   (is (= 230 (puzzlePart2 puzzleTestData))))
