(ns funcprog-1.3.2-test
  (:use funcprog-1.3.2)
  (:use funcprog-1.3.1)
  (:require [clojure.test :as test])
  )

(test/deftest test2
  (test/testing "Testing 1.3.2"
    (test/is (< (abs (- ((give-antiderivative-lazy square) 2.0) ((give-antiderivative-lazy square) 0.0) (/ 8.0 3.0))) 0.1))
    (test/is (< (abs (- ((give-antiderivative-lazy square) 0.0) ((give-antiderivative-lazy square) 0.0) 0.0)) 0.1))
    )
  )