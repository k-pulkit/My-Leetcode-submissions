import scala.collection.mutable.PriorityQueue

class KthLargest(_k: Int, _nums: Array[Int]) {
    final val k = _k
    
    var nums = List.empty[Int]
    private var minHeap = PriorityQueue.empty[Int](Ordering[Int].reverse)
    _nums.foreach(add(_))

    def add(x: Int): Int = {
        nums = x :: nums    // add to the list
        val head = if (minHeap.isEmpty) Int.MaxValue else minHeap.head     // kth largest
        if (minHeap.size < k) {
            minHeap += x
            minHeap.head 
        } else if (x > head) {
            if (!minHeap.isEmpty) minHeap.dequeue()
            minHeap += x
            minHeap.head
        } else head 
    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = new KthLargest(k, nums)
 * var param_1 = obj.add(`val`)
 */