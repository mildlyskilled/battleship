package com.mildlyskilled.actors

import akka.actor.{ActorRef, Actor}
import com.mildlyskilled.common.Player
import com.mildlyskilled.messages._
import scala.collection.mutable.Map

class BattleshipServer extends Actor {
  val connectedPlayers:Map[ActorRef, Player] = Map()

  def canPlay = connectedPlayers.size == 2

  def receive = {
    case BeginGame => println("Game starting")
    case ConnectClient(player) => {
      connectedPlayers += (sender() -> player)
      sender() ! InfoMessage("You're connected")
      if (canPlay) {
        connectedPlayers.foreach({ case (r, _) => r ! InfoMessage("Ready to play")})
        connectedPlayers.keys.head ! YourTurn
      }
    }
    case Play(x: Int, y:Int) => {
      if(canPlay) connectedPlayers.keys.filter(_ != sender()).foreach(r => r ! FireOnCell(x, y))
      else sender() ! "Game not ready"
    }
  }
}
