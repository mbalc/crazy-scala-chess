package crazyscalachess.frontend

import slinky.core.StatelessComponent
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html._

@react class BoardJS extends StatelessComponent {
  type Props = ClientState

  def boardBorderCell(content: String): ReactElement =
    th(className := "board-border")(content)

  // format: off
  def columnDescription: ReactElement =
    tr(
      boardBorderCell(""),
      (1 to props.game.board.columnCount) map (col => boardBorderCell(col.toString)),
      boardBorderCell("")
    )
  // format: on

  def render: ReactElement = {
    table(
      tbody(id := "board-content")(
        columnDescription,
        (props.game.board.rowCount to 1 by -1) map (row => renderRow(row)),
        columnDescription
      )
    )
  }

  def renderRow(row: Int): ReactElement = {
    val rowLetter = ('A' + row - 1).toChar.toString
    tr(key := s"board-row$row")(
      boardBorderCell(rowLetter),
      (1 to props.game.board.columnCount) map (col => renderCell(col, row)),
      boardBorderCell(rowLetter)
    )
  }

  def renderCell(row: Int, col: Int): ReactElement = {
    val onCellClick = props.onCellClick _
    Cell(props.game, props, (row, col), onCellClick)
  }
}
