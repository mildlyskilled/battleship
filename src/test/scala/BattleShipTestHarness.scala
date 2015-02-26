import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestKit}
import org.scalatest.WordSpecLike
import org.scalatest.matchers.MustMatchers

class BattleShipTestHarness extends TestKit(ActorSystem("testSystem"))
// Using the ImplicitSender trait will automatically set `testActor` as the sender
with ImplicitSender
with WordSpecLike
with MustMatchers {

}
