package com.mildlyskilled.actors

import akka.actor.FSM
import com.mildlyskilled.messages._
import com.mildlyskilled.states._

class Cell(coordinates: (Int, Int)) extends FSM[CellState, Message]{

  startWith(Vacant, Init)

//  def occupied: Receive = {
//    case "occupy" => sender() ! "Occupied"
//    case "vacate" => become(vacant)
//    case "activate" => become(activated)
//    case "deactivate" => become(deactivated)
//  }
//
//  def vacant: Receive = {
//    case "vacant" => sender() ! "Vacant"
//    case "occupy" => become(occupied)
//    case "activate" => become(activated)
//    case "deactivate" => become(deactivated)
//  }
//
//  def activated: Receive = {
//    case "vacant" => become(vacant)
//    case "occupy" => become(occupied)
//    case "activate" => sender() ! "Activated"
//    case "deactivate" => become(deactivated)
//  }
//
//  def deactivated: Receive = {
//    case "vacant" => become(vacant)
//    case "occupy" => become(occupied)
//    case "activate" => become(activated)
//    case "deactivate" => sender() ! "Deactivated"
//  }

  when(Active) {
    //
    case Event(PlaceShip, ship) =>
      println("Active")
      stay using ship
  }


  when(Inactive) {
    case Event(PlaceShip, ship) =>
      println("Active")
      stay using ship
  }

  when(Occupied) {
    case Event(PlaceShip, ship) =>
      println("Active")
      stay using ship
  }

  when(Vacant) {
    case Event(PlaceShip, ship) => {
      println("Vacant")
      stay using ship
    }
  }

//  override def receive = {
//
//    case Coordinates => sender ! coordinates
//    case "occupy" => become(occupied)
//    case "vacate" => become(vacant)
//    case "activate" => become(activated)
//    case "deactivate" => become(deactivated)
//  }

  initialize()
}
