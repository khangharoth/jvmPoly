(ns fold.reducer)

(require '[clojure.core.reducers :as r])


(def v (range (* 1 1000000)))

(time (->> v
           (map inc)
           (reduce +)))

(time (->> v
           (r/map inc)
           (r/reduce +)))



(time (->> v
           (r/map inc)
           (r/fold +)))
