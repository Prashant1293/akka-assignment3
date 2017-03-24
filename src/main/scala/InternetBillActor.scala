import akka.actor.{Actor, Props}

/**
  * Created by prashant on 24/3/17.
  */

  class InternetBillActor extends Actor{

    val database = context.actorOf(Props[DatabaseRepo])
    override def receive = {

      case user:UserDetail=> database ! (user,BillerDetail(internet,"Den BoomBand",user.acountNumber,"23/3/2017",1000,3,0,0))
      //context.actorOf(Props[DatabaseRepo]).forward(user,BillerDetails(internet,"Den BoomBand",user.accNumber,"23/3/2017",1000,3,0,0))
    }
  }

