package com.midlyskilled.battleship.client

import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.TerminalSize
import com.googlecode.lanterna.TextCharacter
import com.googlecode.lanterna.TextColor
import com.googlecode.lanterna.graphics.TextGraphics
import com.googlecode.lanterna.screen.TerminalScreen
import com.googlecode.lanterna.terminal.DefaultTerminalFactory
import com.googlecode.lanterna.terminal.ansi.UnixTerminal
import java.nio.charset.Charset

object Gui {

  case class Grid(
    startX: Int,
    startY: Int,
    rows: Int,
    cols: Int,
    rowPad: Int = 2,
    colPad: Int = 4,
    rowLabelPad: Int = 2,
    colLabelPad: Int = 1
  ) {
    val gridX = startX + rowLabelPad
    val gridY = startY + colLabelPad
    val sizeX = 2 * colPad * cols + 1
    val sizeY = 2 * rowPad * rows + 1
    val endX = gridX + sizeX - 1
    val endY = gridY + sizeY - 1
  }

  val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
  val hBar = 0x2500.toChar
  val vBar = 0x2502.toChar
  val tlCorner = 0x250C.toChar
  val trCorner = 0x2514.toChar
  val blCorner = 0x2510.toChar
  val brCorner = 0x2518.toChar

  def pos(x: Int, y: Int) = new TerminalPosition(x, y)

  def size(w: Int, h: Int) = new TerminalSize(w, h)

  def grid(graphics: TextGraphics, g: Grid, color: Option[TextColor] = None): Unit = {
    val prevColor = graphics.getForegroundColor()

    color.foreach(graphics.setForegroundColor)

    graphics.drawLine(g.gridX, g.gridY, g.endX, g.gridY, hBar)
    graphics.drawLine(g.endX, g.gridY, g.endX, g.endY, hBar)
    graphics.drawLine(g.gridX, g.gridY, g.gridX, g.endY, vBar)
    graphics.drawLine(g.endX, g.gridY, g.endX, g.endY, vBar)

    (1 to g.cols) map (_ * 2 * g.colPad) foreach { offset =>
      graphics.drawLine(g.gridX + offset, g.gridY + 1, g.gridX + offset, g.endY, vBar)
    }

    (1 to g.rows) map (_ * 2 * g.rowPad) foreach { offset =>
      graphics.drawLine(g.gridX + 1, g.gridY + offset, g.endX - 1, g.gridY + offset, hBar)
    }

    (0 until g.cols) foreach { idx =>
      graphics.putString(g.gridX + (g.colPad * idx * 2) + g.colPad, g.startY, alphabet(idx).toString())
    }

    (0 until g.rows) foreach { idx =>
      graphics.putString(g.startX, g.gridY + (g.rowPad * idx * 2) + g.rowPad, (idx + 1).toString())
    }

    graphics.putString(g.gridX, g.gridY, tlCorner.toString)
    graphics.putString(g.gridX, g.endY, trCorner.toString)
    graphics.putString(g.endX, g.gridY, blCorner.toString)
    graphics.putString(g.endX, g.endY, brCorner.toString)

    graphics.setForegroundColor(prevColor)
  }
}

object Constants {
  val playerStartX = 4
  val playerStartY = 2
  val enemyStartX = 100
  val enemyStartY = 2
  val rows = 10
  val cols = 10
}

object Main extends App {
  import Constants._

  val terminal = new UnixTerminal(System.in, System.out, Charset.forName("UTF8"))
  val screen = new TerminalScreen(terminal)

  screen.startScreen()

  val graphics = screen.newTextGraphics()
  Gui.grid(graphics, Gui.Grid(playerStartX, playerStartY, rows, cols), Some(TextColor.Indexed.fromRGB(0, 255, 0)))
  Gui.grid(graphics, Gui.Grid(enemyStartX, enemyStartY, rows, cols), Some(TextColor.Indexed.fromRGB(255, 0, 0)))

  screen.refresh()
}
