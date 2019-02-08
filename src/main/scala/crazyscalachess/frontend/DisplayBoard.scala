package crazyscalachess.frontend

import crazyscalachess.Game
import slinky.core.StatelessComponent
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html._

@react class DisplayBoard extends StatelessComponent {
  case class Props(game: Game)

  def columnDescription: ReactElement = tr(
    th(),
    (1 to props.game.board.columnCount) map (col => th(b(col))),
    th()
  )

  def render: ReactElement = {
    table(
      tbody(
        columnDescription,
        (props.game.board.rowCount to 1 by -1) map(row => renderRow(row)),
        columnDescription
      )
    )
  }

  def renderRow(row: Int): ReactElement = {
    val rowLetter = ('A' + row - 1).toChar.toString
    tr(key := s"board-row$row")(
      th(rowLetter),
      (1 to props.game.board.columnCount) map(col => renderCell(row, col)),
      th(rowLetter)
    )
  }

  def renderCell(row: Int, col: Int): ReactElement = {
    td(key := s"board-piece${row}x$col") (
      props.game.board.getCoordinateContent((col, row)) match {
        case None => s"None"
        case Some(piece) => piece.getClass.getSimpleName
      }
    )
  }
}
