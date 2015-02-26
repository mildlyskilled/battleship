package com.mildlyskilled.actors

import akka.actor.{ActorRef, Actor}
import com.mildlyskilled.utils.ShipDirection

/**
 * The base class ship definition that has a definite length provided by the derived case class.
 * @param length the length of the ship
 * @param startCell the cell on which the ship should start building
 * @param direction the direction in which the ship should be facing when built
 */
class Ship(val length: Int, startCell: ActorRef, direction: ShipDirection) extends Actor {

  def build(): Unit = ???

  val occupiedCells: List[ActorRef] = ???

  def receive = ???

}
