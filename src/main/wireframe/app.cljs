(ns wireframe.app
  (:require [reagent.core :as reagent]
            ["@material-ui/core" :as mui]
            ["@material-ui/core/styles" :refer [createMuiTheme]]
            ["@material-ui/core/colors" :as mui-colors]
            ["@material-ui/icons"]))

(defn custom-theme
  []
  (createMuiTheme (clj->js #js {:palette #js {:type "light"
                                              :primary (.-blue mui-colors)
                                              :secondary (.-orange mui-colors)}
                                :typography #js {:useNextVariants true}})))

(defn init []
  (println "Hello World from shadow-cljs")
  (reagent/render [:> mui/MuiThemeProvider
                   {:theme (custom-theme)}
                   [:<>
                    [:> mui/CssBaseline]
                    [:h1 "This is my first, simple heading"]
                    [:> mui/Avatar
                     [:> (.. js/MaterialUI -icons -AndroidIcon) {:color :secondary}]]]]
                  (.getElementById js/document "app")))
