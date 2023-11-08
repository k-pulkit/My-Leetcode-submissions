import scala.collection.mutable.PriorityQueue

object Solution {
    def minStoneSum(piles: Array[Int], k: Int): Int = {
        // create a max heap for the given data
        val f: (Int) => Int = (x) => x - Math.floor(x / 2.0).asInstanceOf[Int]
        var maxH = PriorityQueue.empty[Int]
        piles.foreach {x => 
            maxH.enqueue(x)
            }
        // apply operations k times
        (1 to k).foreach { i =>
            val x: Int = maxH.dequeue()
            val y: Int = f(x)
            maxH.enqueue(y)
        }
        // return result
        maxH.reduce(_+_)
    }
}