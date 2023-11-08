import scala.collection.mutable.PriorityQueue

object Solution {

    case class Monster(distance: Int, speed: Int) {
        def nowAt(time: Int) = distance - speed*time
        def isInCity(time: Int): Boolean = nowAt(time) <= 0
    }

    // order by time taken to reach the city
    implicit val ordering: Ordering[Monster] = Ordering.by((x: Monster) => x.distance.asInstanceOf[Double] / x.speed).reverse  

    def eliminateMaximum(dist: Array[Int], speed: Array[Int]): Int = {
        // create the heap
        var minH = PriorityQueue.empty[Monster]
        dist.zip(speed).map(x => Monster(x._1, x._2)).foreach(minH.enqueue(_))

        def helper(heap: PriorityQueue[Monster])(timeElapsed: Int)(killed: Int): Int = {
            if (heap.isEmpty) killed
            else if (heap.head.isInCity(timeElapsed)) killed
            else {
                // kill monster closest to the city (order by how much time is it going to take to reach us)
                heap.dequeue()
                // time step + 1
                helper(heap)(timeElapsed+1)(killed+1)
            }
        }

        helper(minH)(0)(0)
    }
}