import akka.actor.{ActorSystem, Props}
import akka.util.Timeout
import scala.concurrent.duration._
import akka.pattern.ask
import scala.concurrent.Await


/**
  * Created by prashant on 23/3/17.
  */

object MainCall extends App {

  val system = ActorSystem("Book")
  val props = Props[UserAccountGenerator]
  val router = system.actorOf(props)
  val props1 = Props[SalaryDepositActor]
  val router1 = system.actorOf(props1)

  for(i <- 100 to 110) {
    implicit val timeout = Timeout(1000 seconds)
    val f=router ? (UserDetail("Prashant","Ghaziabad","pras"),i)
    Await.result(f,timeout.duration)
  }

  for(i <- 100 to 110) {
    router1 ! (i.toLong, "pras" + i + 1, (10000 + i).toLong)
  }
}






