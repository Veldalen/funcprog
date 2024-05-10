(ns funcprog-1.1.3)

(defn my-map [f coll]
  (reduce (fn [a b]
            (concat a (list (f b)) ))
          (list)
          coll)
  )

(println (my-map inc (list 1 2 3 4)))

(defn my-filter [pred coll]
  (reduce (fn [a b]
            (if (pred b)
              (concat a (list b))
              a))
          (list)
          coll)
  )

(println (my-filter (fn [n] (= 0 (mod n 3)))
                    (range 1 21)))