(ns data-str.quick-sort)

(defn sort-parts [pivot elements]
  (if (= 0 (count elements))
    elements
    (concat
      (let [value (filter (fn [x] (< x pivot)) elements)]
        (sort-parts (first value) value))
      (filter (fn [x] (.equals x pivot)) elements)
      (let [value (filter (fn [x] (> x pivot)) elements)]
        (sort-parts (first value) value)
        )
      )
    )
  )

(defn quick-sort [x]
  (sort-parts (first x) x))


