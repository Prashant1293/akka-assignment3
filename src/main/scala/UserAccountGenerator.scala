import akka.actor.Actor

/**
  * Created by prashant on 23/3/17.
  */
class UserAccountGenerator extends Actor {
 val userService=new UserAccountService


  override def receive = {
    case user:UserDetail=>{

    }
  }

}
