import org.scalatest.FunSuite
import com.mildlyskilled.actors.Grid

class GridTestSuite extends FunSuite {
  val ourGrid = new Grid
  test("A grid must have should have 10 rows") {
    assert(ourGrid.getRows == 10)
  }

  test("A grid must have 10 columns") {
    assert(ourGrid.getColumns == 10)
  }

  test("A grid must have 100 cells") {
    assert(ourGrid.getCells.size == 100)

  test("A grid must return nothing if coordinates out of the grid") {
    assert(ourGrid.getCell( ('K',50999)).isEmpty)
  }

  test("A grid must return a cell if coordinates in the grid") {
    assert(ourGrid.getCell(('A',1)).isDefined)
  }
}
