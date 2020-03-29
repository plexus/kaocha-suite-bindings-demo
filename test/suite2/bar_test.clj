(ns bar-test
  (:require [clojure.test :refer :all]
            [suite.bind]))

(deftest baz-test
  (println {:*dyn-var* suite.bind/*dyn-var*})
  (is (= 1 1)))
