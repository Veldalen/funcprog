(ns funcprog-1.1.2)

(defn run-alphabet
  ([word result alphabet]
   (if (<= (count alphabet) 0)
     result
     (if (= (.length word) 0)
       (recur word
              (cons (str word (first alphabet))
                    result)
              (rest alphabet))
       (if (= (.substring word (- (.length word) 1))
              (first alphabet))
         (recur word
                result
                (rest alphabet))
         (recur word
                (cons (str word (first alphabet))
                      result)
                (rest alphabet))
         )
       )
     )
   )
  )

(defn add-a-letter
  ([to_process result alphabet]
   (if (<= (count to_process) 0)
     result
     (recur (rest to_process)
            (concat (run-alphabet (first to_process) (list) alphabet)
                    result)
            alphabet)
     )
   )
  )

(defn len-n-words
  ([n alphabet] (len-n-words (list "") n alphabet))
  ([cur n alphabet]
   (if (<= n 0)
     cur
     (recur (add-a-letter cur
                          (list)
                          alphabet)
            (dec n)
            alphabet)
     )
   )
  )

(println (len-n-words 4 (list "a" "b" "c")))