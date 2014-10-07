(ns mapviewer.routes.home
  (:require [compojure.core :refer :all]
            [mapviewer.views.layout :as layout]))

(defn home []
  (layout/common [:div]))

(defroutes home-routes
  (GET "/" [] (home)))
