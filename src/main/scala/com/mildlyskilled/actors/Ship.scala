package com.mildlyskilled.actors

/**
 * The directon of a placed ship
 */
object ShipDirection extends Enumeration {
  val North = Value("N")
  val East = Value("E")
  val South = Value("S")
  val West = Value("W")
}

/**
 * The base class ship defintion that has a definite lenght provided by the derived case class.
 * @param length
 */
abstract class Ship(val length: Int) {

  val startCell: Cell
  val direction: ShipDirection.Value

  val occupiedCells: List[Cell] = {

    // TODO: build the cells that are occupied by the ship on the grid
    return ???

  }


}

/**
 * Different types of ships (with fixed length)
 * @param startCell The start cell of the ship
 * @param direction The direction the ship is pointing when placed *
 */
case class BattleShip(val startCell: Cell, val direction: ShipDirection.Value) extends Ship(6)
case class Submarine(val startCell: Cell, val direction: ShipDirection.Value) extends Ship(5)
case class Cruiser(val startCell: Cell, val direction: ShipDirection.Value) extends Ship(4)
case class Frigate(val startCell: Cell, val direction: ShipDirection.Value) extends Ship(3)
case class Minesweeper(val startCell: Cell, val direction: ShipDirection.Value) extends Ship(2)
case class Dinghy(val startCell: Cell, val direction: ShipDirection.Value) extends Ship(1)
