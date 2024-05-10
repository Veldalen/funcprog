(ns funcprog-1.2.1)

(defn nth-prime [n]
  (letfn [(update-composites [table composite factor]
            (assoc table (+ composite factor) (cons factor (table (+ composite factor)))))
          (primes-step [table candidate nCur primes]
            (if (> nCur 0)
              (if (= nil (table candidate))
                (recur (assoc table (* candidate candidate) (cons candidate (table candidate)))
                       (inc candidate)
                       (dec nCur)
                       (cons candidate primes))
                (recur (reduce #(update-composites %1 candidate %2) table (table candidate))
                       (inc candidate)
                       nCur
                       primes)
                )
              (first primes))
            )
          ]
    (primes-step (hash-map) 2 n (list))))

(println (nth-prime 1000000))

