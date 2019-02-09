# Crazy Scala Chess
This project is, as of now, basically a version of chess with simplified ruleset
that you can compile from Scala to a static webpage where you can play the game in your browser.

Game logic is written in Scala and compiled to JavaScript using Scala.js.
With some effort and Socket trickery the game logic can be easily adapted to a server-client
architecture so it can also be played online using two browsers.

##### Play it live
> \<TODO insert path here when it is deployed>

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

###### Craziness adnotation
> This project was inspired by some ideas I had about board games like chess in general, that they could be generalized
and then I could allow for some crazy variations of the original game. From what I can see after my experiences with
Scala, this idea is easily and pleasantly implementable in this project, but requires much more time than I anticipated.

> So after all - from all the "craziness" that was intended to come true in this project - as it is expressed in
the project title - unfortunately, the main part of it manifested in me pulling an all-nighter
because of how ~~disorganized~~ busy person I was, it seems.

_________
Project created for Languages and Programming Tools III class, Scala group, University of Warsaw

Copyright @mbalc 2019

