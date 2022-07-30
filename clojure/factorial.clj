(ns clojure.misc.factorial
	(:gen-class))

(defn factorial [num]
  (cond 
    (= num 0) 1 ;Factorial of 0 equals 1.
    :else (* num (factorial (- num 1)))
  )
)

(defn main []
  (def nums (list 9 6 3))
  (doseq [num nums] (println (factorial num)))
)

(main)
