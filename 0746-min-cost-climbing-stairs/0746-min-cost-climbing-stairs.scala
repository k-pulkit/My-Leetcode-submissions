
import scala.util.Try
object Solution {

    def minCostClimbingStairs(cost: Array[Int]): Int = {

        val lowestCost: List[Int] = 
            cost.foldRight(List.empty[Int]) {
                (c, result) => {
                    val oneStep: Int = c + result.headOption.getOrElse(0)
                    val twoStep: Int = c + (result match {
                                                case Nil => 0 // If the list is empty (Nil), return 0
                                                case _ => result.tail.headOption.getOrElse(0)
                                           })
                    Math.min(oneStep, twoStep) :: result
                }
            }

        lowestCost match {
            case x :: Nil => x
            case x :: y :: tail => x min y
            case Nil => Int.MaxValue
        }

    }
}