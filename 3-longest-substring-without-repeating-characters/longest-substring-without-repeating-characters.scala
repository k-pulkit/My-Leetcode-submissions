import collection.mutable.{Queue}

object Solution {
    def lengthOfLongestSubstring(s: String): Int = {
        var ans = 0
        var queue = Queue.empty[Char]
        for (c <- s) {
            if (queue.contains(c)) {
                while(queue.head != c) queue.dequeue()
                queue.dequeue()
                queue.enqueue(c)
                ans = ans max queue.length
            } else {
                queue.enqueue(c)
                ans = ans max queue.length
            }
        }

        ans
    }
}