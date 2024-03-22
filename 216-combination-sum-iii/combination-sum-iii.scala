import scala.collection.immutable.{Set, Vector}
import scala.collection.mutable.{Set => MSet}

object Solution {
    def combinationSum3(k: Int, n: Int): List[List[Int]] = {

        var visited: Set[Set[Int]] = Set.empty[Set[Int]]

        def aux(bucket: Vector[Int], n: Int, target: Int): Vector[Set[Int]] = {
            if (n == 1) {
                if (bucket contains target) Vector(Set(target))
                else Vector.empty[Set[Int]]
            } 
            else if (target < 0 || (bucket.isEmpty && target > 0)) Vector.empty[Set[Int]]
            else {

                bucket.zipWithIndex.foldLeft(Vector.empty[Set[Int]]) {
                    case (results, (num, i)) => {
                        val returns: Vector[Set[Int]] = aux(bucket.drop(i+1), n - 1, target - num)
                        returns.map(_ + num) ++ results
                    }
                }
            }
        }

        aux((1 to 9).toVector, k, n).map(_.toList).toList
        
    }
}