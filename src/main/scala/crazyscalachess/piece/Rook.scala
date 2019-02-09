package crazyscalachess.piece

import crazyscalachess.Team
import crazyscalachess.movement.{CardinalDirections, Position}

class Rook(position: Position, team: Team)
    extends Piece(position, team, new CardinalDirections()) {}
