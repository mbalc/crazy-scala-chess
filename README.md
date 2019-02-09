# Crazy Scala Chess
This project is a simplified version of chess that you can play on browser.

### Stack
- Scala
- SBT
- Scalatest
- ScalaJS
- ScalaJS Bundler
- Slinky Shadaj framework
- SCSS

Everything starts with 'S'!

_________

Game logic is written in Scala and compiled to JavaScript using Scala.js.
With some effort and Socket trickery the game logic can be easily adapted to a server-client
architecture so it can be played online using browser.

##### Play it live
> \<TODO insert path here when it is deployed>

### Development:
> copied from manual - I attempted this approach but in this config it is unreliable for me - I instead use manual compilation as described later
```
sbt> fastOptJS::startWebpackDevServer
sbt> ~fastOptJS
```
then finish with
```
sbt> fastOptJS::stopWebpackDevServer
```

### Compilation:
- development build
```
sbt> fastOptJS::webpack
```
- production build
```
sbt> fullOptJS::webpack
```
See sbt output to find path of the output

_________
Project created for Languages and Programming Tools III class, Scala group, University of Warsaw

Copyright @mbalc 2019

