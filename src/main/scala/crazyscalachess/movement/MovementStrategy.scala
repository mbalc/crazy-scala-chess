package crazyscalachess.movement
import crazyscalachess.Types.Coordinates
import crazyscalachess.piece.Piece

abstract class MovementStrategy {
  def possibleMoves(position: Position, piece: Piece): List[Coordinates]
}
