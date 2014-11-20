(ns smiters.core
  (:gen-class)
  (:import [org.fife.ui.rtextarea RTextScrollPane]
           [org.fife.ui.rsyntaxtextarea RSyntaxTextArea SyntaxConstants])
  (:use seesaw.core))

(defn- create-text-area []
  (doto (RSyntaxTextArea. 20 60)
    (.setSyntaxEditingStyle SyntaxConstants/SYNTAX_STYLE_CLOJURE)
    (.setCodeFoldingEnabled true)
    (.setAntiAliasingEnabled true)))

(defn- create-scroll-pane []
  (doto (RTextScrollPane. (create-text-area))
    (.setFoldIndicatorEnabled true)))

(defn- create-frame []
  (let [panel (border-panel :center (create-scroll-pane))]
    (frame :title "Text Editor Demo"
           :on-close :exit
           :content panel)))

(defn -main [& args]
  (invoke-later
    (-> (create-frame)
        pack!
        show!)))
