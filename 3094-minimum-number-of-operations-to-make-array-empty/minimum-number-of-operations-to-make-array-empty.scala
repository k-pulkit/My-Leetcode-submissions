object Solution {

    def findMinFor(x: Int): Int = {
        if (x == 1) -1
        else{
            (
                (0 to x / 2).foldLeft(Set.empty[(Int, Int)]) {
                case (r, c) if (x-2*c)%3==0 => r ++ Set((c, (x-2*c)/3))
                case (r, c) => r
                }
            ++
                (0 to x / 3).foldLeft(Set.empty[(Int, Int)]) {
                case (r, c) if (x-3*c)%2==0 =>  r ++ Set(((x-3*c)/2, c))
                case (r, c) => r
                }
            )
            .map {case (a, b) => a+b}
            .reduce(Math.min)
        }
    }

    def minOperations(nums: Array[Int]): Int = {

        nums.groupMapReduce(x => x)(x => 1)(_ + _)
            .foldLeft(0) {
            case (r, (k, v)) => {
                val x = findMinFor(v)
                if (x == -1 || r == -1) -1 else r+x
            }
        }

    }
}