(ns quick_sort_test
  (:require [clojure.test :refer :all]
            [data-str.quick-sort :refer :all])
  )

(deftest quick-sort-test
  (is (.equals (list 1 2 4 5) (quick-sort (list 2 4 1 5)))))
