/**
  * Created by prashant on 24/3/17.
  */


import scala.collection.mutable.ListBuffer


class SalaryDepositService {

  val userAccount=ListBuffer[UserDetail]()

  def depositing(accNumber:Long,username:String,salary:Long)={

    def iterate(userList:List[UserDetail]):Boolean= {

      userList match {

        case head :: tail  => {
          if (head.acountNumber equals accNumber) {
            val user = head.copy(amount = salary)
            userAccount.append(user)
            true
            // user
          }
          else
            iterate(tail)
        }

        case head :: Nil => {
          if (head.acountNumber equals accNumber) {
            val user = head.copy(amount = salary)
            userAccount.append(user)
            true
            //  user
          }
          else
            false
          // null
        }
      }
    }

    val check=iterate(UserAccountService.userDetails.toList)
    check
    //println(check.username)
    //    if(check!=null)
    //      check.username

  }
}
object SalaryDepositService extends SalaryDepositService