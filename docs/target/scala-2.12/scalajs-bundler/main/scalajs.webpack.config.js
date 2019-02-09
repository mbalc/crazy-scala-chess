module.exports = {
  "entry": {
    "crazy-scala-chess-fastopt": ["/home/mbalc/IdeaProjects/crazy-scala-chess/target/scala-2.12/scalajs-bundler/main/crazy-scala-chess-fastopt.js"]
  },
  "output": {
    "path": "/home/mbalc/IdeaProjects/crazy-scala-chess/target/scala-2.12/scalajs-bundler/main",
    "filename": "[name]-bundle.js"
  },
  "mode": "development",
  "devtool": "source-map",
  "module": {
    "rules": [{
      "test": new RegExp("\\.js$"),
      "enforce": "pre",
      "use": ["source-map-loader"]
    }]
  }
}