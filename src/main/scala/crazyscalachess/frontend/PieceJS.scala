package crazyscalachess.frontend
import crazyscalachess.piece.Piece
import slinky.core.StatelessComponent
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html.{className, div}

@react class PieceJS extends StatelessComponent {
  type Props = Option[Piece]

  override def render(): ReactElement = {

    props match {
      case None => ""
      case Some(piece) =>
        val teamDescription = piece.team.name
        div(className := s"piece team team-$teamDescription")(
          piece.getClass.getSimpleName
            .charAt(0)
            .toString // TODO use https://en.wikipedia.org/wiki/Chess_symbols_in_Unicode
        )
    }
  }
}
