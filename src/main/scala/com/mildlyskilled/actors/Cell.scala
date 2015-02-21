package com.mildlyskilled.actors

case class Cell(coordinates: (Char, Int)) {

  def occupy(state: Boolean) = ???

  def isOccupied:Boolean = ???

  def activate(state: Boolean) = ???

  def isActive:Boolean = ???
}
