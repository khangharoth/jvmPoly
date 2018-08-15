(ns clojure-core.core
  (:gen-class :name com.multi.ClojureMain :methods [#^{:static true} [sum [int int] int]]))

(defn sum [a b] (+ a b))


(defn -sum "A Java-callable wrapper around the 'sum' function."  [n k]
  (sum n k))

