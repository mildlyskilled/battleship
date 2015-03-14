import akka.actor.ActorRef
import akka.testkit.{TestKit, TestActorRef}
import com.mildlyskilled.actors.Grid
import com.mildlyskilled.messages._
import scala.collection.mutable


class GridTestSuite extends BattleShipTestHarness {
  // Creation of the TestActorRef
  val actorRef = TestActorRef[Grid]
  val gridSize = 10
  var cellCount = 0

  override def afterAll() {
    TestKit.shutdownActorSystem(system)
  }

  "A grid actor" must {
    "send back a result" in {
      actorRef ! buildGrid(gridSize)
      // This method assert that the `testActor` has received a specific message
      expectMsg("Grid Built")
    }
    "send back a number of rows" in {
      actorRef ! GridRows
      expectMsg(gridSize)
    }

    "send back a number of columns" in {
      actorRef ! GridColumns
      expectMsg(gridSize)
    }

    "send back a map of cell coordinates and actor references" in {
      actorRef ! GridCells
      expectMsgType[mutable.Map[(Int, Int), ActorRef]]
    }

    "Send back a reference to the Actor" in  {
      actorRef ! Cell(10, 10)
      // Test to make sure the message coming back is of type Option[ActorRef]
      expectMsgType[Option[ActorRef]]
    }
  }

}
