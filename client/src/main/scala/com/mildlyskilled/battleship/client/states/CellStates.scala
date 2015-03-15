package com.mildlyskilled.battleship.client.states

sealed trait CellState
case object Active extends CellState
case object Inactive extends CellState
case object Occupied extends CellState
case object Vacant extends CellState

case class CellData(coordinates: (Int, Int))
