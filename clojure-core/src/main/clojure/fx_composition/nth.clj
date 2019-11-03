(ns fx-composition.nth)


(def numbers '[a b c d e])

(defn second-1 [x] (first (rest x)))
(def second-2 (comp first rest))

(defn third-1 [x] (first (rest (rest x))))
(def third-2 (comp first rest rest))

(println (second-1 numbers))
(println (second-2 numbers))

(println (third-1 numbers))
(println (third-2 numbers))


(defn fnth [n]
  (apply comp
         (cons first
               (take (dec n) (repeat rest)))))

(println ((fnth 1) '[a b c d e]))
(println ((fnth 1) (list "a" "b" "c" "d" "e")))
