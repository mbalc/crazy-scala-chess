package crazyscalachess
import crazyscalachess.Types.{Coordinates, ChessVector}
import crazyscalachess.piece.Piece

class Team(pieces: List[Piece]) {
  def pawnDirection: ChessVector = (0, 1) // TODO for teams
  def getCoordinateContent(coordinates: Coordinates): Option[Piece]
    = pieces find (p => p.position.coordinates == coordinates)
}
