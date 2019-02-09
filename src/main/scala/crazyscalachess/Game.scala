package crazyscalachess
import crazyscalachess.Types.Coordinates
import crazyscalachess.movement.{Move, Position}
import crazyscalachess.piece.Piece

class Game(var board: Board) {
  def move(piece: Piece, newCoordinates: Coordinates): Unit = {
    if (!piece.possibleMoves.contains(newCoordinates)) return
    val oldPosition = piece.position match {
      case None => return
      case Some(pos) => pos
    }
    val capturedPieceOption = capturePotentialPiece(oldPosition.board, newCoordinates)
    piece.moveHistory += new Move(piece.position.get.coordinates, newCoordinates, piece, capturedPieceOption)
    piece.position = Some(new Position(board, newCoordinates))
  }

  private def capturePotentialPiece(board: Board, newCoordinates: Coordinates): Option[Piece] = {
    val capturedPieceOption = board.coordinateContents(newCoordinates)
    capturedPieceOption match {
      case Some(pc) =>
        pc.position = None
        Some(pc)
      case None => None
    }

  }
}
