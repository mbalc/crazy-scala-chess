package crazyscalachess.frontend
import crazyscalachess.chess.ChessGame
import org.scalajs.dom.document
import slinky.web.ReactDOM
import slinky.web.html.{div}

object Main {
  def main(args: Array[String]): Unit = {
    val game = new ChessGame()
    ReactDOM.render(
      div(DisplayBoard(game = game)),
      document.getElementById("container")
    )
  }
}

