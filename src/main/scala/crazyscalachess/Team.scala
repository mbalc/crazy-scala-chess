package crazyscalachess
import crazyscalachess.Types.{Coordinates, ChessVector}
import crazyscalachess.piece.Piece

class Team(var pieces: List[Piece] = null) {
  def pawnDirection: ChessVector = (0, 1) // TODO for teams
  def getCoordinateContent(coordinates: Coordinates): Option[Piece]
    = pieces
    .find (p => p.position match {
      case Some(pos) => pos.coordinates == coordinates
      case None => false
    })
}
