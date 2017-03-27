/**
  * Created by prashant on 24/3/17.
  */

object DBInMemory {

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
          println("Sorry No data found....")
          null
        }
      }
    }
    val check=iterate(SalaryDepositService.userAccount.toList)
    if(check!=null)
      database += (check.userName -> check)
  }
  def paying(user:UserDetail,bill:BillerDetail)=synchronized{
    if(bill.amount<user.amount) {
      val newUserAccount=user.copy(amount = user.amount-bill.amount )
      database -=user.userName
      database +=(newUserAccount.userName->newUserAccount)
    }
    else
      println("Sorry You Don't Have sufficient balance !!")
  }
}
