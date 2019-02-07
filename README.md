# Crazy Scala Chess
Well, here you'll be able to play some chess (at least some simple version of it)
\<TODO insert path here when it is deployed>
### Development:
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
