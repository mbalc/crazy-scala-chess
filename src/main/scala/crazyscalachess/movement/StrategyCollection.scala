package crazyscalachess.movement
import crazyscalachess.Types.Coordinates
import crazyscalachess.piece.Piece

class StrategyCollection (vectorStrats: List[MovementStrategy]) extends MovementStrategy {
  def possibleMoves(position: Position, piece: Piece): List[Coordinates]
    = vectorStrats.flatMap(strat => strat.possibleMoves(position, piece))
}
