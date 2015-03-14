import akka.testkit.{TestActorRef, TestFSMRef, TestKit}
import akka.util.Timeout
import com.mildlyskilled.actors.{Ship, Cell}
import com.mildlyskilled.messages.PlaceShip
import com.mildlyskilled.states.Occupied

import scala.concurrent.duration._

class CellTestSuite extends BattleShipTestHarness{

  implicit val timeout = Timeout(5 seconds)

  override def afterAll() {
    TestKit.shutdownActorSystem(system)
  }
  val fsm = TestFSMRef(new Cell(10, 10))
  val cellActor: TestActorRef[Cell] = fsm

  val shipActor = TestActorRef(new Ship(3))

  "A cell actor" must {

    "place ship" in {
      cellActor ! PlaceShip(shipActor)

      //cell state occupied, data = ship ctor
      assert(fsm.stateName == Occupied)
      assert(fsm.stateData == PlaceShip(shipActor))
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
