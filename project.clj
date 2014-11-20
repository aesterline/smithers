(defproject smiters "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [seesaw "1.4.4"]
                 [com.fifesoft/rsyntaxtextarea "2.5.3"]]
  :main ^:skip-aot smiters.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
