package crazyscalachess.chess
import crazyscalachess.Types.ChessVector
import crazyscalachess.movement.Position
import crazyscalachess.piece._
import crazyscalachess.{Board, Team}

import scala.collection.mutable

object ChessBoardConfigurator {
  val WHITE_MAIN_ROW = 1
  val WHITE_PAWN_ROW = 2
  val BLACK_PAWN_ROW = 7
  val BLACK_MAIN_ROW = 8

  def pawnRow(board: Board, row: Int, team: Team): List[Pawn] =
    (1 to board.columnCount).toList
      .map(col => (col, row))
      .map(coords => new Pawn(new Position(board, coords), team))

  def mainPiecesRow(board: Board, row: Int, team: Team): List[Piece] =
    new Rook(new Position(board, (1, row)), team) ::
      new Knight(new Position(board, (2, row)), team) ::
      new Bishop(new Position(board, (3, row)), team) ::
      new Queen(new Position(board, (4, row)), team) ::
      new King(new Position(board, (5, row)), team) ::
      new Bishop(new Position(board, (6, row)), team) ::
      new Knight(new Position(board, (7, row)), team) ::
      new Rook(new Position(board, (8, row)), team) ::
      Nil

  def teamWithStandardSetup(board: Board,
                            pawnRowNumber: Int,
                            mainPiecesRowNumber: Int,
                            name: String,
                            pawnDirection: ChessVector): Team = {
    val team = new Team(name, pawnDirection)
    val pieces = pawnRow(board, pawnRowNumber, team) ::: mainPiecesRow(
      board,
      mainPiecesRowNumber,
      team
    )
    team.pieces = pieces
    team
  }

  def setupWhiteTeam(board: Board): Team =
    teamWithStandardSetup(
      board,
      WHITE_PAWN_ROW,
      WHITE_MAIN_ROW,
      Teams.WHITE,
      (0, 1)
    )
  def setupBlackTeam(board: Board): Team =
    teamWithStandardSetup(
      board,
      BLACK_PAWN_ROW,
      BLACK_MAIN_ROW,
      Teams.BLACK,
      (0, -1)
    )

  def configuredChessBoard: Board = {
    val board = new Board()
    val whites = setupWhiteTeam(board)
    val blacks = setupBlackTeam(board)
    board.teams = mutable.MutableList(whites, blacks)
    board
  }
}
