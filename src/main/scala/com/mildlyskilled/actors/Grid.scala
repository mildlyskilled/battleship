package com.mildlyskilled.actors

import akka.actor.{ActorRef, Props, Actor}
import com.mildlyskilled.messages.build
import scala.collection.mutable.Map

class Grid extends Actor {
  var rows: Int = 1
  var columns: Int = 1
  var cells =  Map[(Int, Int), ActorRef]()

  def getRows: Int = rows

  def getColumns: Int = columns

  def build(size: Int): Boolean = {
    for (x <- 0 to size) {
      for (y <- 0 to size) {
        val cellActor = context.actorOf(Props(new Cell((x, y))), name = "cell_" + x.toString + y.toString)
        cells += ((x, y) -> cellActor)
      }
    }
    true

  }

  def getCells: List[Cell] = ???

  def getCell(coordinates: (Char, Int)): Option[Cell] = ???

  def receive = {

    case build(s: Int) => {
      if (build(s)) sender ! "Grid Built"
    }

    case _ => {
      sender ! "Blow up"
    }

  }
}
