package com.mildlyskilled.actors

import akka.actor.{Actor, ActorRef, Props}
import com.mildlyskilled.actors.Grid._
import com.mildlyskilled.common.ShipDirection
import com.mildlyskilled.common.ShipDirection.ShipDirection
import com.mildlyskilled.messages._

import scala.collection.mutable

object Grid {

   case class PlaceShipOnGrid(x:Int, y:Int, length:Int, direction: ShipDirection)
   case object StartGame
}
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
    cells
  }

  def getCell(coordinates: (Int, Int)): Option[ActorRef] = {
    println("CELL")
    println(cells.get(coordinates))
    cells.get(coordinates)
  }

   def next(x:Int, y:Int, direction: ShipDirection):(Int, Int) = {
      val xFunc = direction match {
         case ShipDirection.East => (v:Int)=>v+1
         case ShipDirection.West => (v:Int)=>v-1
         case _ => (v:Int)=>v
      }
      val yFunc = direction match {
         case ShipDirection.North => (v:Int)=>v-1
         case ShipDirection.South => (v:Int)=>v+1
         case _ => (v:Int)=>v
      }
      (xFunc(x), yFunc(y))
   }


   def receive = initGrid orElse commonHandler

   def initGrid:Receive = {
      case BuildGrid(s: Int) => {
         if (build(s)) {
            sender ! "Grid Built"
         }
         context.become(gridBuilt orElse commonHandler)
      }
   }

   def gridBuilt : Receive = {
      case PlaceShipOnGrid(x,y,length, direction) =>
         val ship = context.actorOf(Props(classOf[Ship], length))
         (0 until length).foldLeft((x, y)){ case ((x, y), _) => {
            cells((x, y)) ! PlaceShip(ship)
            next(x, y, direction)
         }}
      case StartGame => context.become(playing orElse commonHandler)
   }

   def playing : Receive = {
      case Fire(x, y) =>
   }


   def commonHandler : Receive = {

      case GridRows => sender ! getRows

      case GridColumns => sender ! getColumns

      case GridCells => sender ! getCells

      case Cell(x, y) => sender ! getCell((x, y))

      case _ => {
         sender ! "Blow up"
      }

   }
}
