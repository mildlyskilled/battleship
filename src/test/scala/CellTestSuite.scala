import akka.testkit.{TestFSMRef, TestKit, TestActorRef}
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._
import com.mildlyskilled.messages._
import com.mildlyskilled.actors.Cell

class CellTestSuite extends BattleShipTestHarness{

  implicit val timeout = Timeout(5 seconds)

  override def afterAll() {
    TestKit.shutdownActorSystem(system)
  }
  val fsm = TestFSMRef(new Cell(10, 10))
  val actorRef: TestActorRef[Cell] = fsm

  println(fsm.stateName)
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
