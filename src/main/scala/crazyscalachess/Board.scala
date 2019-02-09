package crazyscalachess

import crazyscalachess.Types.Coordinates
import crazyscalachess.movement.Position
import crazyscalachess.piece.Piece

class Board(var whiteTeam: Team = null, var blackTeam: Team = null) {
  val columnCount = 8
  val rowCount = 8

  def validCoordinates(position: Position): Boolean =
    validCoordinates(position.coordinates)

  def validCoordinates(coordinates: Coordinates): Boolean =
    (1 to columnCount).contains(coordinates _1) &&
      (1 to rowCount).contains(coordinates _2)

  def getCoordinateContent(coordinates: Coordinates): Option[Piece] = {
    (
      whiteTeam getCoordinateContent coordinates,
      blackTeam getCoordinateContent coordinates
    ) match {
      case (Some(piece), _) => Some(piece)
      case (_, Some(piece)) => Some(piece)
      case _                => None
    }
  }

  def getCoordinateContent(position: Position): Option[Piece] =
    getCoordinateContent(position.coordinates)
}
