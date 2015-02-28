package com.mildlyskilled.actors

import akka.actor.{ActorRef, Props, Actor}
import com.mildlyskilled.messages._
import scala.collection.mutable
import scala.collection.mutable.Map

class Grid extends Actor {
  var rows: Int = 0
  var columns: Int = 0
  var cells = mutable.Map[(Int, Int), ActorRef]()

  def getRows: Int = rows

  def getColumns: Int = columns

  def build(size: Int): Boolean = {
    rows = size
    columns = size
    for (x <- 0 to size) {
      for (y <- 0 to size) {
        val cellActor = context.actorOf(Props(new Cell((x, y))), name = "cell_" + x.toString + y.toString)
        cells += ((x, y) -> cellActor)
      }
    }
    true

  }

  def getCells: mutable.Map[(Int, Int), ActorRef] = {
    println("CELLS")
    cells foreach println
    cells
  }

  def getCell(coordinates: (Int, Int)): Option[ActorRef] = {
    println("CELL")
    println(cells.get(coordinates))
    cells.get(coordinates)
  }

  def receive = {

    case buildGrid(s: Int) => {
      if (build(s)) sender ! "Grid Built"
    }

    case GridRows => sender ! getRows

    case GridColumns => sender ! getColumns

    case GridCells => sender ! getCells

    case Cell(x, y) => sender ! getCell((x, y))

    case _ => {
      sender ! "Blow up"
    }

  }
}
