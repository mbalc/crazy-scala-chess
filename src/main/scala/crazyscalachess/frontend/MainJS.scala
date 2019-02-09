package crazyscalachess.frontend
import crazyscalachess.chess.ChessGame
import slinky.core.Component
import slinky.core.annotations.react
import slinky.core.facade.ReactElement

@react class MainJS extends Component {
  type Props = Null
  type State = ClientState

  override def initialState: State =
    new ClientState(newState => setState(newState), new ChessGame(), None)

  override def render(): ReactElement = GameJS(state)
}
