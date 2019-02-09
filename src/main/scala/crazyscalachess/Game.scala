package crazyscalachess
import crazyscalachess.Types.Coordinates
import crazyscalachess.movement.{Move, Position}
import crazyscalachess.piece.Piece

class Game(var board: Board) {
  def move(piece: Piece, newCoordinates: Coordinates): Unit = {
    piece.moveHistory += new Move(piece.position.get.coordinates, newCoordinates, piece)
    piece.position = Some(new Position(board, newCoordinates)) // TODO move to Game, make it sophisticated
  }
}
