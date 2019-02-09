package crazyscalachess.frontend
import crazyscalachess.Types.Coordinates
import slinky.core.StatelessComponent
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html._

@react class Cell extends StatelessComponent {
  case class Props(clientState: ClientState, coordinates: Coordinates)

  override def render(): ReactElement = {
    val (col, row) = props.coordinates
    val isSelected = props.clientState.selectedCoordinates contains props.coordinates
    val selected = if (isSelected) " selected" else ""
    val cellColor = if ((col + row) % 2 == 0) "white" else "black"
    val possibleMove =
      if (props.clientState.possibleMoves contains props.coordinates)
        " possible-move"
      else ""

    td(
      key := s"board-piece${row}x$col",
      className := s"cell$selected $cellColor$possibleMove",
      onClick := (_ => props.clientState.onCellClick(props.coordinates))
    )(
      div(
        props.clientState.game.board
          .getCoordinateContent(props.coordinates) match {
          case None => ""
          case Some(piece) =>
            piece.getClass.getSimpleName
              .charAt(0)
              .toString // TODO use https://en.wikipedia.org/wiki/Chess_symbols_in_Unicode
        }
      )
    )
  }
}
