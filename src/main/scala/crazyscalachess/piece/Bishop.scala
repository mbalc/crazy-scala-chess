package crazyscalachess.piece
import crazyscalachess.Team
import crazyscalachess.movement.{Diagonal, Position}

class Bishop(position: Position, team: Team)
    extends Piece(position, team, new Diagonal()) {}
