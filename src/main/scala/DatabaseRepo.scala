

/**
  * Created by prashant on 24/3/17.
  */

import akka.actor.{Actor, ActorLogging, ActorSystem, Props}
import scala.concurrent.duration._

class DatabaseRepo extends Actor{

  val salaryDepositActor = context.actorOf(Props[SalaryDepositActor])

  override def receive = {

    case user:String=>{
      DBInMemory.storing(user)
      salaryDepositActor ! DBInMemory.database(user)
    }
    case (user:UserDetail,bill:BillerDetail)=>{

      DBInMemory.paying(user,bill)

    }
    case list:SalaryDepositService=>{

      log.info(""+list)
      //println()
    }

  }
}


