package crazyscalachess.movement
import crazyscalachess.Types.Coordinates
import crazyscalachess.piece.Piece

class Move(val from: Coordinates,
           val to: Coordinates,
           piece: Piece,
           capturedPiece: Option[Piece] = None) {}
