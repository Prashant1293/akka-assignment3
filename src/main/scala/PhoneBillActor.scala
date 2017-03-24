/**
  * Created by prashant on 24/3/17.
  */

import akka.actor.{Actor, Props}

class PhoneBillActor extends Actor{

  val database = context.actorOf(Props[DatabaseRepo])
  override def receive = {
    case user:UserDetail=> database ! (user,BillerDetail(phone,"BSNL",user.acountNumber,"23/3/2017",1000,3,0,0))
  }
}