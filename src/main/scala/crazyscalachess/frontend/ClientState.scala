package crazyscalachess.frontend
import crazyscalachess.Game
import crazyscalachess.Types.Coordinates
import crazyscalachess.chess.ChessGame
import crazyscalachess.movement.Position
import crazyscalachess.piece.Piece

class ClientState(updateState: ClientState => Unit,
                  val game: Game = new ChessGame(),
                  val selectedPiece: Option[Piece] = None) {
  def this(updateState: ClientState => Unit, game: Game, selectedPiece: Piece) =
    this(updateState, game, Some(selectedPiece))

  lazy val possibleMoves: List[Coordinates] = {
    selectedPiece match {
      case None        => Nil
      case Some(piece) => piece.possibleMoves
    }
  }

  def updateGame(nextActivePiece: Option[Piece]): Unit =
    updateState(new ClientState(updateState, game, nextActivePiece))

  def onCellClick(clickedCoordinates: Coordinates): Unit = {
    selectedPiece match {
      case None =>
        game.board.coordinateContents(clickedCoordinates) match {
          case None               => updateGame(None)
          case Some(clickedPiece) => updateGame(Some(clickedPiece))
        }
      case Some(piece) =>
        handleFocusChange(piece, clickedCoordinates)
    }
  }

  def handleFocusChange(piece: Piece, newCoordinates: Coordinates): Unit = {
    if (possibleMoves contains newCoordinates)
      handleMoveAttempt(piece, newCoordinates)
    else if (piece.position.get.coordinates == newCoordinates)
      updateGame(None)
    else
      updateGame(game.board.coordinateContents(newCoordinates))
  }

  def handleMoveAttempt(piece: Piece, newCoordinates: Coordinates): Unit = {
    piece.position = Some(new Position(game.board, newCoordinates)) // TODO move to Game, make it sophisticated
    updateGame(None)
  }
}
