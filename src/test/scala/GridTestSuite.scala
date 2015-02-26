import akka.testkit.TestActorRef
import com.mildlyskilled.actors.Grid
import com.mildlyskilled.messages._


class GridTestSuite extends BattleShipTestHarness {
  // Creation of the TestActorRef
  val actorRef = TestActorRef[Grid]
  val gridSize = 10
  "A gird actor" must {
    "send back a result" in {
      actorRef ! buildGrid(gridSize)
      // This method assert that the `testActor` has received a specific message
      expectMsg("Grid Built")
    }
    "send back a number of rows" in {
      actorRef ! rows
      expectMsg(gridSize)
    }

    "send back a number of columns" in {
      actorRef ! columns
      expectMsg(gridSize)
    }
  }

}
