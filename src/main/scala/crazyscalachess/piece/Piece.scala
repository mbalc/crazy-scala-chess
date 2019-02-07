package crazyscalachess.piece

import crazyscalachess.Team
import crazyscalachess.Types.Coordinates
import crazyscalachess.movement.{MovementStrategy, Position, StrategyCollection}

class Piece (val position: Position, val team: Team, val movementStrategies: List[MovementStrategy]) {
  def this(position: Position, team: Team, movementStrategy: MovementStrategy)
    = this(position, team, movementStrategy :: Nil)

  val movementStrategy: MovementStrategy = new StrategyCollection(movementStrategies)

  def capturable_by(piece: Piece): Boolean = team != piece.team

  def possibleMoves: List[Coordinates] = movementStrategy.possibleMoves(position, this)
}
