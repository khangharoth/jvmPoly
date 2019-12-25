(ns com.datastr.chap2.recursion.towerOfHanoi)


(defn towers-of-hanoi [n from to via]
  (when (pos? n)
    (towers-of-hanoi (dec n) from via to)
    (printf "Move from %s to %s\n" from to)
    (recur (dec n) via to from)))

(defn towers-of-hanoi-lazy [n from to via]
  (when (pos? n)
    (lazy-cat (towers-of-hanoi (dec n) from via to)
              (cons [from '-> to]
                    (towers-of-hanoi (dec n) via to from)))))

;(println (towers-of-hanoi-lazy 3 "A" "C" "B"))
(println (towers-of-hanoi 3 "A" "C" "B"))
