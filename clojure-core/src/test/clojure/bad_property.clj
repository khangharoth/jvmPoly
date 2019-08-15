(ns bad-property
  (:require [clojure.test :refer :all]
            [clojure.test.check :as tc]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            ))

(defn bad-property [x]
  (prop/for-all [v x]
                (println v)
                (or (empty? v) (apply <= v))))



(deftest bad-property-test
  (is (not (:pass? (tc/quick-check 10 (bad-property (gen/list gen/small-integer)))))))

(bad-property-test)