import scala.collection.immutable.::
import scala.collection.mutable.ListBuffer

/**
  * Created by prashant on 23/3/17.
  */
class UserAccountService {
  val userDetails = ListBuffer[UserDetail]()

  def userNameVerify(user: UserDetail, num: Int) = {

    def iterate(userList:List[UserDetail]):Boolean= {

      userList match {

        case head :: tail =>{
          if (head.userName equals user.userName)
            true
          else
            iterate(tail)
        }

        case head :: Nil => {

          if (head.userName equals user.userName)
            true
          else
            false
        }
        case Nil=>false
      }
    }
    val check=iterate(userDetails.toList)

    if(check==true)
      println("UserName already exists !!")
    else
      userDetails.append(user.copy(acountNumber = num, userName = user.userName + num + 1))

  }
}

object UserAccountService extends UserAccountService

