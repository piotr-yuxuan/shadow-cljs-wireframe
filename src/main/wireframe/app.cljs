(ns wireframe.app
  (:require [reagent.core :as reagent]
            ["@material-ui/core/styles/MuiThemeProvider" :default mui-ThemeProvider]
            ["@material-ui/core/styles" :refer [createMuiTheme]]
            ["@material-ui/core/colors" :as mui-colors]
            ["@material-ui/core/CssBaseline" :default mui-CssBaseline]
            ["@material-ui/core/Avatar" :default mui-avatar]
            ["@material-ui/icons/Android" :default AndroidIcon]))

(defn custom-theme
  []
  (createMuiTheme (clj->js #js {:palette #js {:type "light"
                                              :primary (.-blue mui-colors)
                                              :secondary (.-orange mui-colors)}
                                :typography #js {:useNextVariants true}})))

(defn init []
  (println "Hello World from shadow-cljs")
  (reagent/render [:> mui-ThemeProvider
                   {:theme (custom-theme)}
                   [:<>
                    [:> mui-CssBaseline]
                    [:h1 "This is my first, simple heading"]
                    [:> mui-avatar
                     [:> AndroidIcon {:color :secondary}]]]]
                  (.getElementById js/document "app")))
