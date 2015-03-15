package com.mildlyskilled.actors

import akka.actor.{Actor, ActorRef}
import com.mildlyskilled.messages.Hit
import scala.collection.mutable

/**
 * The base class ship definition that has a definite length provided by the derived case class.
 * @param length the length of the ship
 */
class Ship(val length: Int) extends Actor {


  val occupiedCells: mutable.Set[ActorRef] = mutable.Set()

  def receive = {
    case Hit => print("Hit")
    case _ => "Message Unknown"
  }

}
