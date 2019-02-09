package crazyscalachess
import crazyscalachess.Types.{ChessVector, Coordinates}
import crazyscalachess.piece.Piece

class Team(val name: String, val pawnDirection: ChessVector = (0, 1)) {
  var pieces: List[Piece] = List[Piece]()

  def getCoordinateContent(coordinates: Coordinates): Option[Piece] =
    pieces.find(
      p =>
        p.position match {
          case Some(pos) => pos.coordinates == coordinates
          case None      => false
      }
    )
}
