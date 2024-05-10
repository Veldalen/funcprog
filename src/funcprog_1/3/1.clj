(ns funcprog-1.3.1)

(def h 0.1)

(defn give-area
  [f t]
  (* h (* 0.5 (+ (f t) (f (+ t h))))))

(defn give-antiderivative
  "Gives antiderivative of a function"
  [f]
  (fn partial-sum [x]
    (if (< 0.0 x)
      (+ (give-area f (- x h)) (partial-sum (- x h)))
      0.0)))


(def partial-sum-memo (memoize (fn [f step acc]
                                 (+ (give-area f step) acc))))

(defn give-antiderivative-memo
  "Gives antiderivative of a function with memoization of partial sums"
  [f]
  (fn ret [x]
    (loop [step 0.0 acc 0.0]
      (if (< step x)
        (recur (+ step h) (partial-sum-memo f step acc))
        acc))))

(defn square [x] (* x x))

(defn -main [& args]
  (time ((give-antiderivative square) 2.0))
  (time ((give-antiderivative square) 2.0))
  (time ((give-antiderivative-memo square) 2.0))
  (time ((give-antiderivative-memo square) 2.0))
  )
