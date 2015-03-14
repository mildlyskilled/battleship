package com.mildlyskilled.messages

case object Coordinates extends Message

case object Active extends Message

case object Occupied extends Message

case class FireOnCell(x:Int, y:Int) extends Message
