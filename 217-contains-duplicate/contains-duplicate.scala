import scala.collection.mutable.Set

object Solution {
    def containsDuplicate(nums: Array[Int]): Boolean = {
        val container: Set[Int] = Set.empty
        nums.exists { (x: Int) => 
            if (container(x)) 
                true
            else {
                container.add(x)
                false
            }
        }
        
    }
}