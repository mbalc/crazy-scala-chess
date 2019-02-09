package crazyscalachess.piece

import crazyscalachess.Team
import crazyscalachess.Types.Coordinates
import crazyscalachess.movement.{MovementStrategy, Position, StrategyCollection}

class Piece(val position: Option[Position],
            val team: Team,
            val movementStrategies: List[MovementStrategy]) {
  def this(position: Option[Position],
           team: Team,
           movementStrategy: MovementStrategy) =
    this(position, team, movementStrategy :: Nil)

  def this(position: Position,
           team: Team,
           movementStrategies: List[MovementStrategy]) =
    this(Some(position), team, movementStrategies)

  def this(position: Position, team: Team, movementStrategy: MovementStrategy) =
    this(Some(position), team, movementStrategy :: Nil)

  val movementStrategy: MovementStrategy = new StrategyCollection(
    movementStrategies
  )

  def capturable_by(piece: Piece): Boolean = team != piece.team

  def possibleMoves: List[Coordinates] = position match {
    case None      => Nil
    case Some(pos) => movementStrategy.possibleMoves(pos, this)
  }
}
