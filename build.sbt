enablePlugins(ScalaJSPlugin)

name := "crazy-scala-chess"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

libraryDependencies += "me.shadaj" %%% "slinky-core" % "0.5.2" // core React functionality, no React DOM
libraryDependencies += "me.shadaj" %%% "slinky-web" % "0.5.2" // React DOM, HTML and SVG tags
libraryDependencies += "me.shadaj" %%% "slinky-native" % "0.5.2" // React Native components
libraryDependencies += "me.shadaj" %%% "slinky-hot" % "0.5.2" // Hot loading, requires react-proxy package
libraryDependencies += "me.shadaj" %%% "slinky-scalajsreact-interop" % "0.5.2" // Interop with japgolly/scalajs-react

// optional, but recommended; enables the @react macro annotation API
addCompilerPlugin(
  "org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full
)

enablePlugins(ScalaJSBundlerPlugin)

npmDependencies in Compile += "react" -> "16.6.1"
npmDependencies in Compile += "react-dom" -> "16.6.1"
npmDependencies in Compile += "react-proxy" -> "1.1.8"

npmDependencies in Compile += "react-router-dom" -> "4.2.2"
npmDependencies in Compile += "react-syntax-highlighter" -> "6.0.4"
npmDependencies in Compile += "remark" -> "8.0.0"
npmDependencies in Compile += "remark-react" -> "4.0.1"
npmDependencies in Compile += "react-helmet" -> "5.2.0"
npmDependencies in Compile += "react-ga" -> "2.5.3"
npmDependencies in Compile += "history" -> "4.7.2"

npmDevDependencies in Compile += "url-loader" -> "0.6.2"
npmDevDependencies in Compile += "css-loader" -> "0.28.7"
npmDevDependencies in Compile += "html-webpack-plugin" -> "3.2.0"
npmDevDependencies in Compile += "copy-webpack-plugin" -> "4.5.1"
npmDevDependencies in Compile += "static-site-generator-webpack-plugin" -> "3.4.1"

version in webpack := "4.5.0"
version in startWebpackDevServer := "3.1.3"

scalacOptions += "-P:scalajs:sjsDefinedByDefault"

scalaJSUseMainModuleInitializer := true
