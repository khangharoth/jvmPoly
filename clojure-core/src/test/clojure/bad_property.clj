(ns bad-property
  (:require [clojure.test :refer :all]
            [clojure.test.check :as tc]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            ))

(def bad-property
  (prop/for-all [v (gen/vector gen/small-integer)]
                (or (empty? v) (apply <= v))))

(println (:pass? (tc/quick-check 100 bad-property)))

(deftest bad-property-test
  (is (not (:pass? (tc/quick-check 100 bad-property)))))