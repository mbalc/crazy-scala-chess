package crazyscalachess

import crazyscalachess.Types.Coordinates
import crazyscalachess.movement.Position
import crazyscalachess.piece.Piece

import scala.language.postfixOps

class Board(var whiteTeam: Team = null, var blackTeam: Team = null) {
  val columnCount = 8
  val rowCount = 8

  def validCoordinates(position: Position): Boolean =
    validCoordinates(position.coordinates)

  def validCoordinates(coordinates: Coordinates): Boolean = {
    val (x, y) = coordinates
    (1 to columnCount).contains(x) && (1 to rowCount).contains(y)
  }

  def coordinateContents(coordinates: Coordinates): Option[Piece] = {
    (
      whiteTeam getCoordinateContent coordinates,
      blackTeam getCoordinateContent coordinates
    ) match {
      case (Some(piece), _) => Some(piece)
      case (_, Some(piece)) => Some(piece)
      case _                => None
    }
  }

  def coordinateContents(position: Position): Option[Piece] =
    coordinateContents(position.coordinates)
}
