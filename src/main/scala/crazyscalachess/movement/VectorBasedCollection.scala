package crazyscalachess.movement
import crazyscalachess.Constants
import crazyscalachess.Types.ChessVector

class VectorBasedCollection (baseVectors: List[ChessVector], limit: Int = Constants.Infinity)
  extends StrategyCollection(baseVectors.map(vector => new VectorBased(vector, limit)))
