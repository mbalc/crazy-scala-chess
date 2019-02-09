package crazyscalachess.piece
import crazyscalachess.Team
import crazyscalachess.movement._

class Pawn(position: Position, team: Team)
    extends Piece(
      position,
      team,
      new VectorBased(team.pawnDirection, 1) ::
        new FirstMoveOnly(new VectorBased(team.pawnDirection, 2)) ::
        new PawnCapture(team.pawnDirection) ::
        new EnPassant() :: Nil
    ) {}
