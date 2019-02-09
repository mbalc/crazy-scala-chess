package crazyscalachess.movement

import crazyscalachess.piece.Piece

class Castling() extends MovementStrategy() {
  override def possibleMoves(position: Position,
                             piece: Piece): List[(Int, Int)] = Nil // TODO castling
}
