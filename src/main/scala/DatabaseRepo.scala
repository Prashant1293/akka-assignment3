/**
  * Created by prashant on 24/3/17.
  */
import akka.actor.{Actor, Props}

class DatabaseRepo extends Actor{

  val salaryDepositActor = context.actorOf(Props[SalaryDepositActor])

  override def receive = {

    case user:String=>{
      // Thread.sleep(2000)
      //println(user)
      DBInMemory.storing(user)
      // println(DBInMemory.database)
      //DBInMemory.database foreach {case (key, value) => println (key + "-->" + value)}
      salaryDepositActor ! DBInMemory.database(user)
    }
    case (user:UserDetail,bill:BillerDetail)=>{

      DBInMemory.paying(user,bill)
      //      sender() ! "Done"
    }
  }
}