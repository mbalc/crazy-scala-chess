package crazyscalachess.movement
import crazyscalachess.Constants

class EightDirections (limit: Int = Constants.Infinity)
  extends StrategyCollection(new Diagonal(limit) :: new CardinalDirections(limit) :: Nil)
