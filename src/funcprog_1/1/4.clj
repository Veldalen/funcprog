(ns funcprog-1.1.4)

(def ner-run-alphabet
  (fn [alphabet]
    (fn [col word]
      (concat col (map (fn [letter] (str word letter))
                       (filter (fn [letter] (not (= (.substring word (- (.length word) 1)) letter)))
                               alphabet))
              )
      )
    )
  )

(def ner-add-a-letter
  (fn [alphabet]
    (fn [col i]
      (if (> (count col) 0)
        (reduce (ner-run-alphabet alphabet)
                (list)
                col)
        alphabet))
    )
  )

(defn ner-len-n-words
  [n alphabet]
  (reduce (ner-add-a-letter alphabet)
          (list)
          (range 0 n))
  )

(println (ner-len-n-words 4 (list "a" "b" "c")))