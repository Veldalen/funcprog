(ns funcprog-1.3.2)

(def h 0.1)

(defn give-area
  [f t]
  (* h (* 0.5 (+ (f t) (f (+ t h))))))

(defn square [x] (* x x))

(defn give-antiderivative-lazy
  "Gives antiderivative of a function"
  [f]
  (let [lazy-area (map #(give-area f %) (iterate #(+ % h) 0.0))]
    (fn [x] (reduce + (take (quot x h) lazy-area)))))

(defn -main [& args]
  (time ((give-antiderivative-lazy square) 2.0))
  (time ((give-antiderivative-lazy square) 2.0))
  )