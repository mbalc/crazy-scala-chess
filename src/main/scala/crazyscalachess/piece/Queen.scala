package crazyscalachess.piece
import crazyscalachess.Team
import crazyscalachess.movement.{EightDirections, Position}

class Queen (position: Position, team: Team)
  extends Piece(position, team, new EightDirections()) {

}
