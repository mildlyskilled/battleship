import akka.actor.Props
import akka.testkit.{TestKit, TestActorRef}
import com.mildlyskilled.actors.{Ship, Cell}
import com.mildlyskilled.messages._
import com.mildlyskilled.utils.ShipDirection

class ShipTestSuite extends BattleShipTestHarness {

  val cellActor = TestActorRef(Props(new Cell((0, 0))))
  val actorRef = TestActorRef(Props(new Ship(6)))

  override def afterAll() {
    TestKit.shutdownActorSystem(system)
  }

  "A ship actor" must {
    "send back a valid number of occupied cells" in {
      actorRef ! occupiedCells
      expectMsg(Nil)
    }
    "send back an active status" in {
      actorRef ! activeStatus
      expectMsg(true)
    }

    "send back a direction" in {
      actorRef ! direction
      expectMsg('N')
    }
  }


}
