import com.mildlyskilled.actors.{ShipDirection, BattleShip, Cell, Ship}
import org.scalatest.FunSuite

class ShipTestSuite extends FunSuite {

  val aShip = new BattleShip(new Cell('A',1), ShipDirection.East)


  test("A ship must have a valid direction") {
    assert(aShip.direction != None)
    assert(ShipDirection.values.contains(aShip.direction))
  }

  test("A ship must have a length") {
    assert(aShip.length != 0)
  }

  test("A ship must occupy cells equal to its length") {
    assert(aShip.occupiedCells.length == aShip.length)
  }


  test("A ship must have set of coordinates equal to cells occupied") {
    assert(false)

  }

  test("A ship must have set of coordinates on the grid") {
    assert(false)
  }



}
