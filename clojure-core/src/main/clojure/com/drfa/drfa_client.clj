(ns com.drfa.drfa-client
  [:require [com.drfa.drfa :refer :all]
            [clojure.java.io :as io]])

; For running in intellij
;(def base-file-name "../../../../test/resources/drfa/base.csv")
;(def target-file-name "../../../../test/resources/drfa/target.csv")

(def base-file-name "src/test/resources/drfa/base.csv")
(def target-file-name "src/test/resources/drfa/target.csv")

(def field-indexes (list 0, 2))
(def base-key-indexes (list 0))
(def target-key-indexes (list 0))

(def base-file (split-line (readFile base-file-name)))
(def target-file (split-line (readFile target-file-name)))

(def base-map (to-map base-file base-key-indexes field-indexes))
(def target-map (to-map target-file target-key-indexes field-indexes))

(defn int-expression [base-value target-value]
  (= base-value target-value))

(def column-matchers
  (list (->column-matchers "C1" int-expression)))

(println (match base-map target-map column-matchers))

