import scala.collection.immutable.::
import scala.collection.mutable.ListBuffer

/**
  * Created by prashant on 23/3/17.
  */
class UserAccountService {
  val userDetails = ListBuffer[UserDetail]()

  def userNameVerify(user: UserDetail, num: Int) = {
    userDetails.toList match {
      case head :: tail => {
        if (head.userName equals user.userName)
          println("UserName already Exists")
        else
          userDetails.append(user.copy(acountNumber = num))
      }
      case head :: Nil => {
        if (head.userName equals user.userName)
          println("UserName already Exists")
        else
          userDetails.append(user.copy(acountNumber = num))

      }
      case Nil => userDetails.append(user.copy(acountNumber = num))

    }
  }
}


