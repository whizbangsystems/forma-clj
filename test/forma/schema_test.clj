(ns forma.schema-test
  "This namespace provides unit testing coverage for the forma.schema namespace."
  (:use forma.schema
        [midje sweet cascalog])
  (:require [forma.date-time :as date])
  (:import [forma.schema
            FireTuple]))

(tabular
 (fact
   "Test thrifter multimethod: (thrifter FireTuple 1 2 3 4) => (FireTuple. 1 2 3 4)"
   (thrifter ?thrift-type ?temp330 ?conf50 ?bothPreds ?count) => ?thrift-obj)
 ?thrift-type ?temp330 ?conf50 ?bothPreds ?count ?thrift-obj
 FireTuple 11 22 33 44 (FireTuple. 11 22 33 44))

(tabular
 (fact
   "Test unpack method: (unpack (FireTuple. 1 2 3 4)) => [1 2 3 4]"
   (unpack ?thrift-obj ?keys) => ?vals)
 ?thrift-obj ?keys ?vals
 (FireTuple. 11 22 33 44) [] [11 22 33 44]
 (FireTuple. 11 22 33 44) [:temp330] [11]
 (FireTuple. 11 22 33 44) [:conf50] [22]
 (FireTuple. 11 22 33 44) [:bothPreds] [33]
 (FireTuple. 11 22 33 44) [:count] [44]
 (FireTuple. 11 22 33 44) [:temp330 :conf50 :bothPreds :count] [11 22 33 44]
 (FireTuple. 11 22 33 44) [:count :bothPreds :conf50 :temp330] [44 33 22 11])
