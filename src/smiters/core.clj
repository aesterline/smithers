(ns smiters.core
  (:gen-class)
  (:require [seesaw.chooser :as chooser])
  (:import [org.fife.ui.rtextarea RTextScrollPane]
           [org.fife.ui.rsyntaxtextarea RSyntaxTextArea SyntaxConstants])
  (:use seesaw.core))

(defn- create-code-area []
  (doto (RSyntaxTextArea. 20 60)
    (.setSyntaxEditingStyle SyntaxConstants/SYNTAX_STYLE_CLOJURE)
    (.setCodeFoldingEnabled true)
    (.setAntiAliasingEnabled true)))

(defn- display-code [ide]
  (let [scroll-pane (doto (RTextScrollPane. (:code-area ide))
                      (.setFoldIndicatorEnabled true))]
    (config! (:ide ide) :content (border-panel :center scroll-pane))
    ide))

(defn create-editor [ide]
  (-> ide
      (assoc :code-area (create-code-area))
      (display-code)))

(defn show-file [app file]
  (config! (:code-area app) :text (slurp file)))

(defn display! [app]
  (-> (:ide app)
      pack!
      show!))

(defn create-ide []
  (-> {:ide (frame :title "Text Editor Demo" :on-close :exit)}
      create-editor))

(defn -main [& args]
  (native!)
  (invoke-later
    (-> (create-ide)
        display!)))
