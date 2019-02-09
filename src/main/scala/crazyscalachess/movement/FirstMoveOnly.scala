package crazyscalachess.movement
import crazyscalachess.piece.Piece

class FirstMoveOnly(strategy: MovementStrategy) extends MovementStrategy {
  override def possibleMoves(
    position: Position,
    piece: Piece
  ): List[(Int, Int)] = {
    if (piece.moveHistory.isEmpty)
      strategy.possibleMoves(position, piece)
    else
      Nil
  }
}
