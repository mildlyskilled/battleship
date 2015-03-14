package com.mildlyskilled.actors

import akka.actor.FSM
import com.mildlyskilled.messages._
import com.mildlyskilled.states._

class Cell(coordinates: (Int, Int)) extends FSM[CellState, Message]{

  startWith(Vacant, Init)

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
    case Event(Fire(_,_), PlaceShip(ship)) =>
      println("Active")
      ship ! Hit
      goto(Inactive)
  }

  when(Vacant) {
    case Event(PlaceShip(ship), _) => {

      goto(Occupied) using PlaceShip(ship)
    }

  }

  initialize()
}
