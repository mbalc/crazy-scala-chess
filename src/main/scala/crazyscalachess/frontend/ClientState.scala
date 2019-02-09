package crazyscalachess.frontend
import crazyscalachess.Game
import crazyscalachess.Types.Coordinates
import crazyscalachess.chess.ChessGame

class ClientState(updateState: ClientState => Unit,
                  val game: Game = new ChessGame(),
                  val selectedCoordinates: Option[(Int, Int)] = None) {
  def this(updateState: ClientState => Unit,
           game: Game,
           selectedCoordinates: (Int, Int)) =
    this(updateState, game, Some(selectedCoordinates))

  def onCellClick(newCoordinates: Coordinates): Unit =
    updateState(new ClientState(updateState, game, newCoordinates))
}
