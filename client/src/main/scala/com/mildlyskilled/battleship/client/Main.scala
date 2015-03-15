package com.midlyskilled.battleship.client

import com.googlecode.lanterna.TextCharacter
import com.googlecode.lanterna.TextColor
import com.googlecode.lanterna.screen.TerminalScreen
import com.googlecode.lanterna.terminal.ansi.UnixTerminal
import java.nio.charset.Charset

object Constants {
  val gridsStartX = 4
  val gridsStartY = 2
  val rows = 10
  val cols = 10
}

object Main extends App {
  import Constants._

  val terminal = new UnixTerminal(System.in, System.out, Charset.forName("UTF8"))
  val screen = new TerminalScreen(terminal)

  screen.startScreen()

  val playerGrid = Gui.Grid(gridsStartX, gridsStartY, rows, cols)
  val enemyGrid = Gui.Grid(playerGrid.endX + 10, gridsStartY, rows, cols)

  val graphics = screen.newTextGraphics()
  Gui.grid(graphics, playerGrid, Some(TextColor.Indexed.fromRGB(0, 255, 0)))
  Gui.grid(graphics, enemyGrid, Some(TextColor.Indexed.fromRGB(255, 0, 0)))

  graphics.putString(playerGrid.startX, playerGrid.endY + 5, "Press a key to continue...")

  screen.refresh()

  screen.readInput()

   // we need to resolve the server
   // then create two player actors
   // system.actorOf(Props(classOf[PlayerActor]), "p1")
   // system.actorOf(Props(classOf[PlayerActor]), "p2")



  screen.stopScreen()
}
