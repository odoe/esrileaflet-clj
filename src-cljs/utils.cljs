(ns site.utils)

(def L (this-as ct (aget ct "L")))

(def esri (.-esri L))

(def utilTemplate (.-template (.-Util L)))

(def ctr (array 45.528 -122.680))

(def zoom 13)
