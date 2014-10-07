(ns mapviewer.views.layout
  (:require [hiccup.page :refer [html5 include-css]]
            [hiccup.page :refer [include-css include-js]]))

(defn common [& body]
  (html5
    [:head
     [:title "Welcome to mapviewer"]
     (include-css "/css/screen.css")
     (include-css "http://cdn.leafletjs.com/leaflet-0.7.3/leaflet.css")]
    [:body body
     [:div {:id "map"}]
     (include-js "http://cdn.leafletjs.com/leaflet-0.7.3/leaflet.js")
     (include-js "http://cdn-geoweb.s3.amazonaws.com/esri-leaflet/0.0.1-beta.5/esri-leaflet.js")
     (include-js "/js/main.js")
     [:script "site.init();"]]))
