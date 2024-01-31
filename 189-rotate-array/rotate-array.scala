object Solution {
    def rotate(nums: Array[Int], k: Int): Unit = {

        for (ki <- 1 to k) {
            var buffer = nums(0)
            for (i <- 1 until nums.length) {
                val tosave = nums(i)
                nums(i) = buffer
                buffer = tosave
            }
            nums(0) = buffer
        }
        
    }
}