import akka.actor.Actor

/**
  * Created by prashant on 23/3/17.
  */
class UserAccountGenerator extends Actor {
  val userService = new UserAccountService


  override def receive = {
    case (user: UserDetail, num: Int) => {
      UserAccountService.userNameVerify(user, num)
      sender() ! true

    }

  }
}


