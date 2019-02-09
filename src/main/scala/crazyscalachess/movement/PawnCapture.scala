package crazyscalachess.movement

import crazyscalachess.Types.ChessVector
import crazyscalachess.piece.Piece
class PawnCapture(baseVector: ChessVector) extends MovementStrategy() {
  override def possibleMoves(position: Position,
                             piece: Piece): List[(Int, Int)] =
    Nil // TODO pawn capture
}
