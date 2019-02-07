package crazyscalachess.movement
import crazyscalachess.Constants

class CardinalDirections (limit: Int = Constants.Infinity)
    extends VectorBasedCollection((-1, 0) :: (1, 0) :: (0, -1) :: (0, 1) :: Nil, limit)
