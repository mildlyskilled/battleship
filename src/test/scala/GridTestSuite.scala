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
  }

}
