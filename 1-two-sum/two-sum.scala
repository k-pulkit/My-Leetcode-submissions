object Solution {
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
        val map = (0 until nums.length).groupMap (i => nums(i)) (i => i)

        val (k, v) = map.find {
            case (k, v) => {
                if (k != target-k) map.contains(target-k) else v.length > 1
            }
        }.get

        if (k != target-k) Array(v(0), map(target-k)(0)) else Array(v(0), v(1))
        
    }
}