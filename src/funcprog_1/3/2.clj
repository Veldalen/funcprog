(ns funcprog-1.3.2)

(def h 0.1)

(defn give-area
  [f t]
  (* h (* 0.5 (+ (f t) (f (+ t h))))))

(defn square [x] (* x x))

(defn num-integration-lazy
  [f x]
  (let [lazy-partial-sum (reductions (fn [sum num] (+ sum (give-area f num))) 0.0 (iterate #(+ % h) 0.0))]
    (nth lazy-partial-sum (quot x h)))
  )

((defn -main [& args]
   (time (num-integration-lazy square 2.0))
   (time (num-integration-lazy square 2.0))
   (time (num-integration-lazy square 2.1))
   ))