(ns com.pack-bin.pack-bin
  (:import (java.util UUID)))

(defn uuid []
  (str (UUID/randomUUID)))

(defn sum [coll]
  (reduce + coll))

(defn generate-containers [n size]
  (into {} (for [_ (range n) :let [id (uuid)]]
             {id {:size size :contents [] :id id}})))

(defn generate-bins [n max-size]
  (vec (for [_ (range n)]
         {:id (uuid) :size (rand-int max-size)})))

(defn container-space [container]
  (- (:size container) (sum (map :size (:contents container)))))

(defn container-with-space [bin container]
  (> (container-space container) (:size bin)))

(defn selected-container [containers bin]
  (first (filter (partial container-with-space bin) (vals containers))))

(defn pack-bin [containers bin]
  (let [selected-container (selected-container containers bin)]
    (when selected-container
      (update-in containers [(:id selected-container) :contents] conj bin))))

(defn pack-bins [containers bins]
  (reduce pack-bin containers bins))




(pack-bins (generate-containers 2 12) (generate-bins 6 10))
