(ns quick-check-test
  (:require [clojure.test :refer :all]
            [clojure.test.check :as tc]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            ))

(def property
  (prop/for-all [v (gen/vector gen/small-integer)]
                (let [s (sort v)]
                  (and (= (count v) (count s))
                       (or (empty? s)
                           (apply <= s))))))



(deftest good-property-test
  (is (:pass? (tc/quick-check 100 property))))