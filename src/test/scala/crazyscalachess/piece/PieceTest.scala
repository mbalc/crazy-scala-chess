package crazyscalachess.piece

import crazyscalachess.Types.Coordinates
import crazyscalachess.movement.{
  MockMovementStrategy,
  MovementStrategy,
  Position
}
import crazyscalachess.{Board, Team}
import org.scalatest.{FlatSpec, Matchers}

class PieceTest extends FlatSpec with Matchers {
  val fakeTeam = new Team(List[Piece]())
  val board = new Board(fakeTeam, fakeTeam)

  it should "list all possible moves from its strategies" in {
    val pos1 = Array((1, 2), (4, 3))
    val pos2 = Array((2, 2), (4, 7), (3, 6))
    val fakeCoords = Array((5, 2), (5, 7), (5, 6))

    val Seq(strat1, strat2) =
      Seq(pos1, pos2).map(posList => new MockMovementStrategy(posList))
    val piece = new Piece(
      new Position(board, (5, 5)),
      fakeTeam,
      List[MovementStrategy](strat1, strat2)
    )
    val coordinateList = piece.possibleMoves

    pos1.foreach(coords => coordinateList should contain(coords))
    pos2.foreach(coords => coordinateList should contain(coords))
    fakeCoords.foreach(coords => coordinateList should not contain coords)
  }

  it should "not be able to move if there are no move strategies" in {
    val piece =
      new Piece(new Position(board, (5, 5)), fakeTeam, List[MovementStrategy]())
    assert(piece.possibleMoves == List[Coordinates]())
  }

  it should "not be able to move if move strategies don't return anything" in {
    val emptyStrat = new MockMovementStrategy(List[Coordinates]())
    val piece = new Piece(
      new Position(board, (5, 5)),
      fakeTeam,
      List[MovementStrategy](emptyStrat, emptyStrat, emptyStrat)
    )
    assert(piece.possibleMoves == List[Coordinates]())
  }
}
