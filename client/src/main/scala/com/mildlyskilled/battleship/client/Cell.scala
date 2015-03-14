package com.mildlyskilled.battleship.client

import akka.actor.FSM
import com.mildlyskilled.battleship.messages._
import com.mildlyskilled.battleship.client.states._

class Cell(coordinates: (Int, Int)) extends FSM[CellState, Message]{

  startWith(Vacant, Init)

  when(Active) {
    //
    case Event(PlaceShip, ship) =>
      stay using ship
  }


  when(Inactive) {
    case Event(PlaceShip, ship) =>
      stay using ship
  }

  when(Occupied) {
    case Event(Fire, PlaceShip(ship)) =>
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
