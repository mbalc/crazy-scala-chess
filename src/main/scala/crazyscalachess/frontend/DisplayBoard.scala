package crazyscalachess.frontend

import crazyscalachess.Game
import slinky.core.StatelessComponent
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html.h1

@react class DisplayBoard extends StatelessComponent {
  case class Props(game: Game)

  def render: ReactElement = {
    h1(s"Hello oegao")
  }
}
