import com.mildlyskilled.actors.Cell
import org.scalatest.FunSuite

class CellTestSuite extends FunSuite{

  val aCell = new Cell('A',1)

  test("A cell must have coordinates") {
    assert(aCell.coordinates != null)
    assert(aCell.coordinates._1 == 'A')
    assert(aCell.coordinates._2 == 1)

  }

}
