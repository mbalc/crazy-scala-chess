package crazyscalachess.frontend
import crazyscalachess.Game
import org.scalajs.dom.document
import slinky.web.ReactDOM
import slinky.web.html.{div, h1}

object Main {
  def main(args: Array[String]): Unit = {
    val game = new Game()
    ReactDOM.render(
      div(DisplayBoard(game = game)),
      document.getElementById("container")
    )
  }
}

