package crazyscalachess.frontend
import crazyscalachess.Game
import crazyscalachess.Types.Coordinates
import slinky.core.StatelessComponent
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html._

@react class Cell extends StatelessComponent {
  case class Props(game: Game,
                   clickHandler: ClientState,
                   coordinates: Coordinates,
                   onCellClick: Coordinates => _)
  override def render(): ReactElement = {
    val (col, row) = props.coordinates
    val isSelected = props.clickHandler.selectedCoordinates contains props.coordinates
    val selected = if (isSelected) " selected" else ""
    val cellColor = if ((col + row) % 2 == 0) "white" else "black"

    td(
      key := s"board-piece${row}x$col",
      className := s"cell$selected $cellColor",
      onClick := (_ => props.onCellClick(props.coordinates))
    )(
      div(onClick := (_ => props.onCellClick(props.coordinates)))(
        props.game.board.getCoordinateContent(props.coordinates) match {
          case None        => s"None"
          case Some(piece) => piece.getClass.getSimpleName
        }
      )
    )
  }
}
