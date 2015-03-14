package com.mildlyskilled.battleship.client

import akka.actor._
import com.mildlyskilled.common.Player
import com.mildlyskilled.battleship.messages.{FireOnCell, YourTurn, ConnectClient}
import com.mildlyskilled.battleship.client.PlayerActor.Start
import com.mildlyskilled.battleship.client.Grid.PlaceShipOnGrid

object PlayerActor {
   case object Start
}
class PlayerActor(server:ActorRef) extends Actor {

   val player = Player(context.props.toString)
   val grid = context.actorOf(Props(classOf[Grid], 10, 10))
   def receive = {
      case place:PlaceShipOnGrid =>
         grid ! place
      case Start =>

         server ! ConnectClient(player)
         context.become(gridReady(grid))
   }

   def gridReady(grid:ActorRef) :Receive = {
      case YourTurn =>
      case fire: FireOnCell =>
         (grid ? fire).pipeTo(sender())
   }
}