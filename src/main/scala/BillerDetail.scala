//import java.util.Locale.Category

/**
  * Created by prashant on 23/3/17.
  */

sealed trait Category extends Product with Serializable

case object phone extends Category
case object electricity extends Category
case object internet extends Category
case object food extends Category
case object car extends Category

case class BillerDetail(billerCategory:Category, billerName:String, acnNum:Long, transactionDate:String, amount:Long,totalIteration:Int,
                        executedIter:Int,paidAmount:Long) {

}
