package crazyscalachess.movement

import crazyscalachess.Constants

class LShaped (limit: Int = Constants.Infinity)
  extends VectorBasedCollection(
    (-2, -1) :: (-2, 1) :: (-1, -2) :: (-1, 2)
    :: (2, -1) :: (2, 1) :: (1, -2) :: (1, 2)
    :: Nil
  , limit)
