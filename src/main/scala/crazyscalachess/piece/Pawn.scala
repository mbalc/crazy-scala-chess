package crazyscalachess.piece
import crazyscalachess.Team
import crazyscalachess.movement._

class Pawn(position: Position, team: Team)
    extends Piece(
      position,
      team,
      new VectorBased(team.pawnDirection, 1) ::
        new FirstMoveOnly(new VectorBased(team.pawnDirection, 2)) ::
        new CaptureOnly({
        val (x, y) = team.pawnDirection
        new VectorBasedCollection((x + 1, y) :: (x - 1, y) :: Nil, 1)
      }) ::
        new EnPassant() :: Nil
    ) {}
