(ns proxy.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [tailrecursion.ring-proxy :refer [wrap-proxy]]))

(defroutes app-routes
  (GET "/" [] "hello! Yes, this is proxy.")
  (route/not-found "Not Found"))

(def app
  (-> app-routes
      (wrap-proxy "/proxied-counter" "http://localhost:3000/")))