(ns site
  (:require [site.utils :refer [L esri utilTemplate ctr zoom]]))

(defn parkStyle []
  (clj->js { :color "#70ca49", :weight 2 }))

(def opts (clj->js { :style parkStyle }))

(def parkUrl "http://services.arcgis.com/rOo16HdIMeOBI4Mb/arcgis/rest/services/Portland_Parks/FeatureServer/0")

(def popupTemplate "<h3>{NAME}</h3>{ACRES} Acres<br><small>Property ID: {PROPERTYID}<small>")

(defn boundTemplate [feature]
  (utilTemplate popupTemplate (.-properties feature)))

(defn bindPopup [f]
  (.bindPopup f boundTemplate))

(defn basemap [m]
  (let [b (-> esri (.basemapLayer "Gray")
                    (.addTo m))] m))

(defn fLayer [options m]
  (let [f (-> esri (.featureLayer parkUrl options)
                    (.addTo m))], f))

(defn loadMap []
  (let [m (-> L (.map "map")
              (.setView ctr zoom))] m))

(defn ^:export init []
  ((comp bindPopup (partial fLayer opts) basemap loadMap)))
