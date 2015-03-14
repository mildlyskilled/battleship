package com.mildlyskilled.messages

import com.mildlyskilled.common.Player

case object BeginGame extends Message

case class ConnectClient(player: Player) extends Message

case class InfoMessage(msg: String) extends Message

case object YourTurn extends Message

case class Play(x: Int, y: Int) extends Message