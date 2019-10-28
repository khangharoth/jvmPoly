(ns high-order-fx-test
  (:require [clojure.test :refer :all]
            [fx-composition.high :refer :all]))




(deftest applyTwice-test
  (is (.equals 16 (applyTwice (fn [x] (+ x 3)) 10))))


(applyTwice-test)