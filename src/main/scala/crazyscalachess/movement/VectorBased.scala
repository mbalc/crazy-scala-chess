package crazyscalachess.movement
import crazyscalachess.Constants
import crazyscalachess.Types.{ChessVector, Coordinates}
import crazyscalachess.piece.Piece

class VectorBased(baseVector: ChessVector, limit: Int = Constants.Infinity)
    extends MovementStrategy {
  def possibleMoves(position: Position, piece: Piece): List[Coordinates] =
    reachable(position, piece, limit)

  private def reachable(position: Position,
                        piece: Piece,
                        range: Int): List[Coordinates] = {
    if (range < 1) return Nil
    position + baseVector match {
      case None => Nil
      case Some(a) =>
        position.board.getCoordinateContent(a) match {
          case None => a.coordinates :: reachable(a, piece, range - 1)
          case Some(collidingPiece) =>
            if (collidingPiece.capturable_by(piece)) {
              a.coordinates :: Nil
            } else {
              Nil
            }
        }
    }
  }
}
