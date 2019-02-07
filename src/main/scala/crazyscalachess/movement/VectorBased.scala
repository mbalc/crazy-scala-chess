package crazyscalachess.movement
import crazyscalachess.Types.{Coordinates, ChessVector}
import crazyscalachess.Constants
import crazyscalachess.piece.Piece

class VectorBased(baseVector: ChessVector, limit: Int = Constants.Infinity) extends MovementStrategy { // TODO support infinite limits
  def possibleMoves(position: Position, piece: Piece): List[Coordinates] = {
    reachable(position, piece, limit)
  }

  private

  def reachable(position: Position, piece: Piece, range: Int): List[Coordinates] = {
    position + baseVector match {
      case None => Nil
      case Some(a) => position.board.getCoordinateContent(a) match {
        case None =>  a.coordinates :: possibleMoves(a, piece)
        case Some(collidingPiece) => if (collidingPiece.capturable_by(piece)) {
          a.coordinates :: Nil
        } else {
          Nil
        }
      }
    }
  }
}
