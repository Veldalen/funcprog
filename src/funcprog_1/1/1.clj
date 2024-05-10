(ns funcprog-1.1.1)

(defn transpositions
  ([n alphabet] (transpositions "" n (list) alphabet))
  ([cur n left right]
   (if (> n 0)
     (concat (if (not (= right (list)))
               (transpositions (str cur (first right))
                               (dec n)
                               (list (first right))
                               (concat left (rest right))))
             (if (> (count right) 0)
               (transpositions cur
                               n
                               (cons (first right) left)
                               (rest right))))
     (list cur)))
  )

(println (transpositions 3 (list "a" "b" "c")))