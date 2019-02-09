package crazyscalachess.movement

import crazyscalachess.piece.Piece

class EnPassant() extends MovementStrategy() {
  override def possibleMoves(position: Position,
                             piece: Piece): List[(Int, Int)] =
    Nil // TODO en passant
}
