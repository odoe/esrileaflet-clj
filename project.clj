(defproject mapviewer "0.1.0-SNAPSHOT"
  :description "Sample Esri_Leaflet application in ClojureScript"
  :url "http://www.odoe.net/"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.5"]
                 [ring-server "0.3.1"]
                 [org.clojure/tools.reader "0.7.10"]
                 [org.clojure/clojurescript "0.0-1806"]
                 [domina "1.0.0"]
                 [cljs-ajax "0.2.0"]]
  :plugins [[lein-ring "0.8.12"] [lein-cljsbuild "0.3.2"]]
  :cljsbuild
  {:builds
   [{:source-paths ["src-cljs"]
     :compiler
     {:pretty-print true
      :output-to "resources/public/js/main.js"}}]}
  :ring {:handler mapviewer.handler/app
         :init mapviewer.handler/init
         :destroy mapviewer.handler/destroy}
  :profiles
  {:uberjar {:aot :all}
   :production
   {:ring
    {:open-browser? false, :stacktraces? false, :auto-reload? false}}
   :dev
   {:dependencies [[ring-mock "0.1.5"] [ring/ring-devel "1.3.1"]]}})
