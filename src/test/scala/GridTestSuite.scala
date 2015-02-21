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

  test("A coordinate should point to a given square on the grid") {
    //assert(ourGrid.getPoint(1, 'A') == )
  }

  test("must be able to return a cell given set of coordinate") {
    val c:Cell = new Cell('A', 1)
    assert(outGrid.getCell('A', 1) == Cell
  }
}
