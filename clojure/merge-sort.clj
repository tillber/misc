(ns clojure.examples.sort
    (:require [clojure.string :as str-util])
	(:gen-class))

;; Merges two sorted lists. Returns a single sorted list.
(defn merge-list [l, r]
(cond 
    (empty? l) r
    (empty? r) l
    (< (first l) (first r)) 
        (conj (merge-list (rest l) r) (first l))
    :else ;(>= (first l) (first r)) 
        (conj (merge-list l (rest r)) (first r))
)
)

;; Splits the given list in half. Returns a vector containing the two list halves.
(defn split-list [l] (split-at (/ (count l) 2) l))

(defn sort-list [list]
(cond
    (or (= (count list) 1) (empty? list)) list
    :else 
    (let [splitted-list (split-list list)] ;Split the given list
            (let [l-sorted (sort-list (first splitted-list)) 
                  r-sorted (sort-list(second splitted-list))] ;Sort the two lists
            (merge-list l-sorted r-sorted) ;Merge the two sorted lists
            )
    )
)
)

(defn str-list [list] (str-util/join ", " list))

(defn main []
;;Unsorted list
(def unsorted-list (list 28 3 48 39 34 57 46 61 20 49 16 27 6 95 43 37 85 40 67 81 41 92 32))

(println (format "Unsorted list: %s" (str-list unsorted-list)))
(println "Starting merge sort...")

;;Perform merge sort on list
(def sorted-list (sort-list unsorted-list))

(println "Finished sorting!")
(println (format "Sorted list: %s" (str-list sorted-list)))
)

(main)