package com.mildlyskilled.actors

import akka.actor.Actor

class Cell(coordinates: (Int, Int)) extends Actor{
  var isOccupied: Boolean = false
  var isActive = true

  def occupy(state: Boolean) = isOccupied = state

  def activate(state: Boolean) = isActive = state

  def receive = ???

}
