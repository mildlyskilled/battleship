package com.mildlyskilled.messages

import akka.actor.ActorRef

case class PlaceShip(ship: ActorRef) extends Message
case class Fire(x:Int, y:Int) extends Message
case object Init extends Message
