package com.mildlyskilled.actors

case class Grid() {

  def getRows: Int = 1

  def getColumns: Int = 1

  def build: Boolean = ???

  def getCells: List[Cell] = ???

  def getCell(coordinates: (Char, Int)) :Option[Cell] = ???

}
