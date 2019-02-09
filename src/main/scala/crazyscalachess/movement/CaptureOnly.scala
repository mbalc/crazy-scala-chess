package crazyscalachess.movement

import crazyscalachess.piece.Piece
class CaptureOnly(strategies: List[MovementStrategy])
    extends MovementStrategy() {
  def this(strat: MovementStrategy) = this(strat :: Nil)

  override def possibleMoves(position: Position,
                             piece: Piece): List[(Int, Int)] = {
    strategies
      .flatMap(_ possibleMoves (position, piece))
      .filter(
        coords =>
          position.board.coordinateContents(coords) match {
            case None                   => false
            case Some(destinationPiece) => destinationPiece.capturableBy(piece)
        }
      )
  }
}
