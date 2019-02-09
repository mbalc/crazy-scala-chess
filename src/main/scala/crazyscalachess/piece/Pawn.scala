package crazyscalachess.piece
import crazyscalachess.Team
import crazyscalachess.movement.{Position, VectorBased}

class Pawn(position: Position, team: Team)
    extends Piece(position, team, new VectorBased(team.pawnDirection, 1)) {}
