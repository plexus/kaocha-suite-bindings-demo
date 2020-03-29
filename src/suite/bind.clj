(ns suite.bind
  (:require [kaocha.plugin :refer [defplugin]]))

(def ^:dynamic *dyn-var* nil)

(defplugin suite.bind/per-suite-bindings
  (pre-test [testable test-plan]
    (when-let [b (:bindings testable)]
      (push-thread-bindings (into {} (map (juxt (comp resolve key) val)) b)))
    testable)

  (post-test [testable test-plan]
    (when (:bindings testable)
      (pop-thread-bindings))
    testable))
