package crazyscalachess.movement

import crazyscalachess.Board
import crazyscalachess.Types.{ChessVector, Coordinates}

class Position(val board: Board, val coordinates: Coordinates) {
  def +(vector: ChessVector): Option[Position] = {
    val output = new Position(
      board,
      (vector._1 + coordinates._1, vector._2 + coordinates._2)
    )
    if (board validCoordinates this) None else Some(output)
  }
}
