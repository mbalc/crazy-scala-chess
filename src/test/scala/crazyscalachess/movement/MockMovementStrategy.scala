package crazyscalachess.movement
import crazyscalachess.Types.Coordinates
import crazyscalachess.piece.Piece

class MockMovementStrategy(possibleMoveResults: Iterable[Coordinates]) extends MovementStrategy {
  def possibleMoves(pos: Position, piece: Piece): List[Coordinates]
    = possibleMoveResults.map(tuple => tuple).toList
}
