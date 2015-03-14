package com.mildlyskilled

import akka.actor.{ActorSystem, Props}
import com.mildlyskilled.actors.BattleshipServer
import com.typesafe.config.ConfigFactory
import com.mildlyskilled.messages._


object Battleship extends App{
  // start a server to for grids etc
  // get the grids to create cells
  // allow the user to place ships
  // start game

  println("Starting Battleship game server")
  val system = ActorSystem("Battleship", ConfigFactory.load.getConfig("battleshipserver"))
  val server = system.actorOf(Props[BattleshipServer], name="battleshipserver")
  server ! BeginGame
}


