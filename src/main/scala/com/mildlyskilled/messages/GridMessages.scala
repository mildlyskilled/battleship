package com.mildlyskilled.messages

case class buildGrid(size: Int) extends Message
case object GridRows extends Message
case object GridColumns extends Message
case object GridCells extends Message
case class Cell(x: Int, y: Int) extends Message