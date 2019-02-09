package crazyscalachess.piece

import crazyscalachess.Team
import crazyscalachess.Types.Coordinates
import crazyscalachess.movement.{Move, MovementStrategy, Position, StrategyCollection}

import scala.collection.mutable

class Piece(var position: Option[Position],
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

  val moveHistory: mutable.MutableList[Move] = mutable.MutableList()

  def capturableBy(piece: Piece): Boolean = team != piece.team

  def possibleMoves: List[Coordinates] = position match {
    case None      => Nil
    case Some(pos) => movementStrategy.possibleMoves(pos, this)
  }
}
