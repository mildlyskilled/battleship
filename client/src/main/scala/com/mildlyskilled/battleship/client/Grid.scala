package com.mildlyskilled.battleship.client

import akka.actor._
import akka.pattern._
import scala.collection.mutable
import com.mildlyskilled.common.ShipDirection.ShipDirection
import com.mildlyskilled.common.ShipDirection
import com.mildlyskilled.battleship.client.Grid._
import com.mildlyskilled.battleship.messages._
object Grid {

   case class PlaceShipOnGrid(x:Int, y:Int, length:Int, direction: ShipDirection)
   case object Fire
   case class InvalidCoords(x:Int, y:Int)
   case class PlaceShip(ship:ActorRef)
   case object StartGame
}

class Grid(rows: Int, columns: Int) extends Actor {
  var cells = mutable.Map[(Int, Int), ActorRef]()

  def build(size: Int): Boolean = {
    for (x <- 0 to size) {
      for (y <- 0 to size) {
        val cellActor = context.actorOf(Props(new Cell((x, y))), name = "cell_" + x.toString + y.toString)
        cells += ((x, y) -> cellActor)
      }
    }
    true
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
      case FireOnCell(x, y) =>
         cells.get((x, y)) match {
            case Some(ref) => (ref ? Fire).pipeTo(sender())
            case None => sender() ! InvalidCoords(x, y)
         }
   }

   def commonHandler : Receive = {

      case GridRows => sender ! rows

      case GridColumns => sender ! columns

      case GridCells => sender ! cells

      case Cell(x, y) => sender ! cells.get((x, y))

      case _ => {
         sender ! "Blow up"
      }

   }
}
