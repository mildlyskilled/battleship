package com.mildlyskilled.actors

import akka.actor.{ActorRef, Actor}
import com.mildlyskilled.common.ShipDirection

/**
 * The base class ship definition that has a definite length provided by the derived case class.
 * @param cellCount the length of the ship
 */
class Ship(val cellCount: Int) extends Actor {

  def build(): Unit = ???

  val occupiedCells: List[ActorRef] = ???

  def receive = ???

}
