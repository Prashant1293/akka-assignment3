/**
  * Created by prashant on 24/3/17.
  */

class DBInMemory {

  val database= collection.mutable.Map[String, UserDetail]()

  def storing(user:String)={

    def iterate(salaryList:List[UserDetail]):UserDetail= {

      salaryList match {

        case head :: tail  => {
          if (head.userName equals user) {
            head
          }
          else
            iterate(tail)
        }

        case head :: Nil => {
          if (head.userName equals user) {
            head
          }
          else
            null
        }
        case Nil=>{
          println("No data found")
          null
        }
      }
    }
    // println(user+" >>>>>>>>> "+SalaryDepositService.userAccount.toList)
    val check=iterate(SalaryDepositService.userAccount.toList)
    // println(check)
    if(check!=null)
      database += (check.userName -> check)


    //println(check.username)
  }
  def paying(user:UserDetail,bill:BillerDetail)=synchronized{

    //    database foreach {case (key, value) => println (key + "-->" + value)}
    //    println()
    if(bill.amount<user.amount) {

      database(user.userName) = UserDetail(user.actHolderName, user.address, user.userName, user.amount - bill.amount, user.acountNumber)
      println(user.userName+">>>>>>>>"+database)
    }
    else
      println("Insufficient balance !!")
    //    database foreach {case (key, value) => println (key + "-->" + value)}
  }
}
object DBInMemory extends DBInMemory