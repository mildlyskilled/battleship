import akka.testkit.{TestActorRef, TestFSMRef, TestKit}
import akka.util.Timeout
import com.mildlyskilled.actors.Cell
import com.mildlyskilled.messages.Fire
import scala.concurrent.duration._

class CellTestSuite extends BattleShipTestHarness{

  implicit val timeout = Timeout(5 seconds)

  override def afterAll() {
    TestKit.shutdownActorSystem(system)
  }
  val fsm = TestFSMRef(new Cell(10, 10))
  val actorRef: TestActorRef[Cell] = fsm


  "A cell actor" must {

    "send back hit" in {
      actorRef ! Fire


    }

  }

  //println(fsm.stateName)
  /*"A cell actor" must {
    "send back it's coordinates" in {
      fsm ! Coordinates
    }

    "send back it's occupied status" in {
      actorRef ! "occupy"
    }

    "send back it's active status" in {
      val active = actorRef ? Active
      println(active.value.get)
    }
  }*/
}
