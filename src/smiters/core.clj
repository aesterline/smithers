(ns smiters.core
  (:gen-class)
  (:use seesaw.core))

(defn -main [& args]
  (invoke-later
    (-> (frame :title "Hello",
               :content "Hello, Seesaw",
               :on-close :exit)
        pack!
        show!)))
