package com.mildlyskilled.actors

case class Grid() {
  def grid = List((1, 'A'), (2, 'B'), (3, 'C'), (4, 'D'), (5, 'E'), (6, 'F'),(7, 'G'), (8, 'H'), (9, 'I'), (10, 'J'))

  def getRows: Int = 1

  def getColumns: Int = 1

  def getCells: List[Cell] = ???

  def getCell(coordinates: (Char, Int)) :Option[Cell] = ???

}
