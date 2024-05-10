(ns funcprog-1.3.1-test
  (:use funcprog-1.3.1)
  (:require [clojure.test :as test])
  )

(test/deftest test1
  (test/testing "Testing 1.3.1"
    (test/is (< (abs (- ((give-antiderivative square) 2.0) (/ 8.0 3.0))) 0.1))
    (test/is (< (abs (- ((give-antiderivative square) 0.0) 0.0)) 0.1))
    (test/is (< (abs (- ((give-antiderivative-memo square) 2.0) (/ 8.0 3.0))) 0.1))
    (test/is (< (abs (- ((give-antiderivative-memo square) 0.0) 0.0)) 0.1))
    )
  )