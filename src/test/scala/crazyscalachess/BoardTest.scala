package crazyscalachess
import crazyscalachess.chess.ChessGame
import org.scalatest.FlatSpec

class BoardTest extends FlatSpec {
  val game = new ChessGame()
  val xwidth: Int = game.board.columnCount
  val ywidth: Int = game.board.rowCount
  behavior of "Board"

  "Coordinate validation" should "not accept coordinates beyond board" in {
    assert(!game.board.validCoordinates((-15, -221)) )
    assert(!game.board.validCoordinates((-72, 5*ywidth)) )
    assert(!game.board.validCoordinates((4*xwidth, 2*ywidth)) )
    assert(!game.board.validCoordinates((0, 0)) )
    assert(!game.board.validCoordinates((xwidth, ywidth + 1)) )
  }

  it should "accept coordinates within range" in {
    assert(game.board.validCoordinates((1, 1)) )
    assert(game.board.validCoordinates((xwidth, ywidth)) )
    assert(game.board.validCoordinates((1, ywidth)) )
    assert(game.board.validCoordinates((xwidth, ywidth / 3)) )
  }

}
