package crazyscalachess.frontend
import slinky.core.StatelessComponent
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html.div

@react class GameJS extends StatelessComponent {
  type Props = ClientState

  override def render(): ReactElement = {
    div(BoardJS(props))
  }
}
