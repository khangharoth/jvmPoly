(ns fx-composition.high)


(defn applyTwice [fx x]
  (fx (fx x)))


(defn addThree [x]
  (+ x 3))