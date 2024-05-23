(ns funcprog-1.3.1)

(def h 0.1)

(defn give-area
  [f t]
  (* h (* 0.5 (+ (f t) (f (+ t h))))))

(defn num-integration
  "Gives antiderivative of a function"
  [f]
  (fn partial-sum [x]
    (if (< 0.0 x)
      (+ (give-area f (- x h)) (partial-sum (- x h)))
      0.0)))

(def num-integration-memo
  (memoize
    (fn [f x]
      (if (< 0.0 x)
        (+ (give-area f (- x h)) (num-integration-memo f (- x h)))
        0.0
        ))
    )
  )

(defn square [x] (* x x))

(defn -main [& args]
  (time ((num-integration square) 2.0))
  (time ((num-integration square) 2.0))
  (time (num-integration-memo square 2.0))
  (time (num-integration-memo square 2.0))
  (time (num-integration-memo square 2.1))
  )