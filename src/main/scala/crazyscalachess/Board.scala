package crazyscalachess

import crazyscalachess.Types.Coordinates
import crazyscalachess.movement.Position
import crazyscalachess.piece.Piece

import scala.collection.mutable
import scala.language.postfixOps

class Board() {
  var teams: mutable.MutableList[Team] = mutable.MutableList() // TODO add alternating team moves

  val columnCount = 8
  val rowCount = 8

  def validCoordinates(position: Position): Boolean =
    validCoordinates(position.coordinates)

  def validCoordinates(coordinates: Coordinates): Boolean = {
    val (x, y) = coordinates
    (1 to columnCount).contains(x) && (1 to rowCount).contains(y)
  }

  def coordinateContents(coordinates: Coordinates): Option[Piece] = {
    teams.flatMap(_ getCoordinateContent coordinates).headOption
  }

  def coordinateContents(position: Position): Option[Piece] =
    coordinateContents(position.coordinates)
}
