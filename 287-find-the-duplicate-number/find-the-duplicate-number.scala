object Solution {
    def findDuplicate(nums: Array[Int]): Int = {

        var index = 0
        var break = false
        var repeated = 0
        while(!break && index < nums.size) {
            val x = nums(index)
            if (x == index+1) index+=1
            else {
                val y = nums(x-1)
                if (x == y) {
                    repeated=x
                    break = true
                }
                else {
                    nums(index) = y
                    nums(x-1) = x
                }
            }
        }

        repeated
        
    }
}