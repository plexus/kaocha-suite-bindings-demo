(ns foo-test
  (:require [clojure.test :refer :all]
            [suite.bind]))

(deftest bar-test
  (println {:*dyn-var* suite.bind/*dyn-var*})
  (is (= 1 1)))
