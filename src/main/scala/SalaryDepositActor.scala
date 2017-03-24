/**
  * Created by prashant on 24/3/17.
  */

import akka.actor.{Actor, Props}
import akka.util.Timeout

import scala.concurrent.duration.DurationInt
import akka.pattern.ask

import scala.concurrent.Await

class SalaryDepositActor extends Actor{

  val database = context.actorOf(Props[DatabaseRepo])
  val phone = context.actorOf(Props[PhoneBillActor])
  val electricity = context.actorOf(Props[ElectricityBillActor])
  val internet = context.actorOf(Props[InternetBillActor])
  var count=0
  override def receive = {

    case (accNumber:Long,username:String,amount:Long)=>{


      // Thread.sleep(1000)
      val check=SalaryDepositService.depositing(accNumber,username,amount)
      //println(SalaryDepositService.userAccount.toList)

      //      if(user!=Nil)
      //        println(count+1)
      // println(username)
      if(check==true)
        database ! username

    }
    case user:UserDetail=>{

      //      implicit val timeout = Timeout(1000 seconds)
      //      val f=phone ? user
      //      Await.result(f,timeout.duration)
      //      //implicit val timeout1 = Timeout(1000 seconds)
      //      val f1=electricity ? user
      //      Await.result(f1,timeout.duration)
      //      //implicit val timeout2 = Timeout(1000 seconds)
      //      val f2=electricity ? user
      //      Await.result(f2,timeout.duration)
      phone ! user
      electricity ! user
      internet ! user

    }
    //case _=>println("no")
  }
}