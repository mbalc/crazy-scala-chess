package crazyscalachess.piece
import crazyscalachess.Team
import crazyscalachess.movement.{Castling, EightDirections, Position}

class King(position: Position, team: Team)
    extends Piece(
      position,
      team,
      new EightDirections(1) :: new Castling() :: Nil
    ) {
  override def capturableBy(piece: Piece): Boolean = false
}
