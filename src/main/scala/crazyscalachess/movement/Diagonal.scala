package crazyscalachess.movement
import crazyscalachess.Constants

class Diagonal (limit: Int = Constants.Infinity)
  extends VectorBasedCollection((-1, -1) :: (-1, 1) :: (1, -1) :: (1, 1) :: Nil, limit)
