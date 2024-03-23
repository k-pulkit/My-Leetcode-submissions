import scala.collection.mutable.Map

object Solution {
    def rob(nums: Array[Int]): Int = {

        // Map for cache for DP
        val cache: Map[Int, Int] = Map.empty[Int, Int]

        def aux(x: Array[Int])(sliceFrom: Int): Int = {
            // If know the max for that index return it
            if (cache.contains(sliceFrom)) {
                // println(s"Cache hit at $sliceFrom")
                cache(sliceFrom)
            }
            // If at last index
            else if (sliceFrom == x.size-1) x(sliceFrom)
            else {
                var resultMax = -1
                var p1 = sliceFrom
                // Two pointer approach, first is fixed and second iterates
                while(p1 < x.size) {
                    var p2 = p1+2
                    var localMax = 0
                    while(p2 < x.size) {
                        // for second pointer, recurive call to function
                        // returns max as per contract
                        localMax = localMax max aux(x)(p2)
                        p2 += 1
                    }
                    resultMax = resultMax max (localMax+x(p1))
                    p1 += 1
                }
                // store in cache
                cache.update(sliceFrom, resultMax)
                // println(cache)
                resultMax
            }
        }

        // Call helper
        if (nums.size == 1) nums.head
        else aux(nums.drop(1))(0) max {
            cache.clear()
            aux(nums.dropRight(1))(0) 
        }

    }

}


