package com.mildlyskilled.actors

import akka.actor.{Actor, ActorRef}
import com.mildlyskilled.messages.Hit

/**
 * The base class ship definition that has a definite length provided by the derived case class.
 * @param length the length of the ship
 */
class Ship(val length: Int) extends Actor {

  def build(): Unit = ???

  val occupiedCells: List[ActorRef] = ???

  def receive = {
    case Hit => {
      print("Hit")
    }
  }

}
