package crazyscalachess.movement
import crazyscalachess.chess.ChessGame
import org.scalatest.FlatSpec

class PositionTest extends FlatSpec {
  behavior of "Position"

  val coords: (Int, Int) = (3, 5)
  val (x, y) = coords

  val game = new ChessGame()
  val pos = new Position(game.board, coords)

  val xwidth: Int = game.board.columnCount
  val ywidth: Int = game.board.rowCount

  "Vector addition" should "not go outside of the board" in {
    assert((pos + (3 * xwidth, 3 * ywidth)).isEmpty)
    assert((pos + (-3 * xwidth, -3 * ywidth)).isEmpty)
  }

  it should "reach (1) edges" in {
    val pos1 = pos + (1 - x, 0)
    val pos2 = pos + (0, 1 - y)
    assert(pos1.isDefined)
    assert(pos2.isDefined)
    assert(pos1.get.coordinates == (1, y))
    assert(pos2.get.coordinates == (x, 1))
  }

  it should "not go beyond (1) range" in {
    assert((pos + (-x, 0)).isEmpty)
    assert((pos + (0, -y)).isEmpty)
  }

  it should "reach (board max coord) edges" in {
    val pos1 = pos + (xwidth - x, 0)
    val pos2 = pos + (0, ywidth - y)
    assert(pos1.isDefined)
    assert(pos2.isDefined)
    assert(pos1.get.coordinates == (xwidth, y))
    assert(pos2.get.coordinates == (x, ywidth))
  }

  it should "not go beyond (board max coord) range" in {
    assert((pos + (xwidth - x + 1, 0)).isEmpty)
    assert((pos + (0, ywidth - y + 1)).isEmpty)
  }
}
