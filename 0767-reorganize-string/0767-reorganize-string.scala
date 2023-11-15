import scala.collection.mutable.{PriorityQueue}
import scala.annotation.tailrec

object Solution {

    type Occurance = (Char, Int)

    /*
    Reorganise the string so that no two consecutive letters are the same.
    If that cannot be done, then return an empty string.

    Examples - 
    aab -> aba
    aaab -> ''

    Hint - Arrange the elements that have higest freq together
    */
    def reorganizeString(s: String): String = {

        // init max heap and populate it for the given string
        var maxHeap = PriorityQueue.empty[Occurance] (Ordering.by(_._2))
        s.groupMapReduce(x => x)(x => 1)(_ + _).foreach(x => maxHeap.enqueue(x._1 -> x._2))

        @tailrec
        def aux(heap: PriorityQueue[Occurance])(state: String): String = 
            if (heap.isEmpty)       // we processed every char
                state
            else if (heap.size == 1) {     // only 1 chars are left
                val onlyOne: Occurance = heap.dequeue()
                if (onlyOne._2 > 1) "" else s"$state${onlyOne._1}"
            } else {
                val topOne: Occurance = heap.dequeue()
                val topTwo: Occurance = heap.dequeue()
                // decrease frequency by 1 and push to queue
                (topOne, topTwo) match {
                    case ((_, 1), (_, 1)) => ()
                    case (_, (_, 1)) => heap.enqueue(topOne._1 -> (topOne._2-1))
                    case ((_, 1), _) => heap.enqueue(topTwo._1 -> (topTwo._2-1))
                    case _ => heap.enqueue(topOne._1 -> (topOne._2-1), topTwo._1 -> (topTwo._2-1))
                }
                // return result recursively
                aux(heap)(s"$state${topOne._1}${topTwo._1}")
            }
        
        aux(maxHeap)("")

    }
    
}