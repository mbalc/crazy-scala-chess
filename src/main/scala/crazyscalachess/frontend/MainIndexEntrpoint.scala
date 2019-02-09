package crazyscalachess.frontend
import org.scalajs.dom.document
import slinky.web.ReactDOM
import slinky.web.html.div

object MainIndexEntrpoint {
  def main(args: Array[String]): Unit = {
    ReactDOM.render(div(MainJS(null)), document.getElementById("container"))
  }
}
