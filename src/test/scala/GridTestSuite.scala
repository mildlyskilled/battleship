import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestActorRef, TestKit}
import com.mildlyskilled.actors.Grid
import com.mildlyskilled.messages.build
import org.scalatest.WordSpecLike
import org.scalatest.matchers.MustMatchers


class GridTestSuite extends TestKit(ActorSystem("testSystem"))
// Using the ImplicitSender trait will automatically set `testActor` as the sender
with ImplicitSender
with WordSpecLike
with MustMatchers {

  "A gird actor" must {
    "send back a result" in {
      // Creation of the TestActorRef
      val actorRef = TestActorRef[Grid]
      actorRef ! build(10)
      // This method assert that the `testActor` has received a specific message
      expectMsg("Grid Built")
    }
  }

}
