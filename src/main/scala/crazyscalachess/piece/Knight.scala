package crazyscalachess.piece
import crazyscalachess.Team
import crazyscalachess.movement.{LShaped, Position}

class Knight(position: Position, team: Team)
    extends Piece(position, team, new LShaped(1)) {}
