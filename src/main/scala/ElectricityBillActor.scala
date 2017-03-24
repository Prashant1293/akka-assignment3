/**
  * Created by prashant on 24/3/17.
  */
import akka.actor.{Actor, Props}

class ElectricityBillActor extends Actor{

  val database = context.actorOf(Props[DatabaseRepo])
  override def receive = {

    case user:UserDetail=> database ! (user,BillerDetail(electricity,"Yamuna Power",user.acountNumber,"23/3/2017",1000,3,0,0))
    //context.actorOf(Props[DatabaseRepo]).forward(user,BillerDetails(electricity,"Yamuna Power",user.accNumber,"23/3/2017",1000,3,0,0))
  }
}