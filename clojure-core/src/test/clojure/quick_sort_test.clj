(ns quick-sort-test
  (:require [clojure.test :refer :all]
            [data-str.quick-sort :refer :all]))

(defn rand-ints [n]
  (take n (repeatedly #(rand-int n))))

(deftest quick-sort-test
  (is (.equals (list 1 2 4 5) (quick-sort (list 2 4 1 5)))))

(deftest quick-sort-siple-test
  (println (quick-sort (rand-ints 20)))
  (is (.equals (list 1 2 4 5) (quick-sort (list 2 4 1 5)))))





