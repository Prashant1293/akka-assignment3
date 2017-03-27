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

      val check=SalaryDepositService.depositing(accNumber,username,amount)
      if(check==true)
        database ! username

    }
    case user:UserDetail=>{

      phone ! user
      electricity ! user
      internet ! user

    }
  }
}