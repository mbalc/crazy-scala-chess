package crazyscalachess.piece
import crazyscalachess.Team
import crazyscalachess.movement.{EightDirections, Position}

class King(position: Position, team: Team)
    extends Piece(position, team, new EightDirections(1)) {
  override def capturableBy(piece: Piece): Boolean = false
}
