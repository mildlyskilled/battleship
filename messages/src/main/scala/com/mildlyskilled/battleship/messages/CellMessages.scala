package com.mildlyskilled.battleship.messages

import akka.actor.ActorRef

case class PlaceShip(ship: ActorRef) extends Message

case object Fire extends Message

case object Init extends Message
