object Solution {
    /*
    * numbers to add in set {1 to 9}
    * k is {2 to 9}
    * n is {1 to 60}
    */
    def combinationSum3(k: Int, n: Int): List[List[Int]] = {

        def aux(k: Int, n: Int)(selectedNums: List[Int]): Option[List[List[Int]]] = {
            // terminal case - return list if sum matches target
            // else, return none

            // find the next number for iteration
                val head = selectedNums match {
                    case Nil => 0
                    case _ => selectedNums.head
                }

            if (k == 0) {
                val sumOfNums = selectedNums.reduce(_ + _)
                if (sumOfNums == n) Some(List(selectedNums)) else None
            }
            else if (head == 9 && k > 0) {
                return None
            }
            else {
                // call the function recursively for remaining digits
                val result = (head+1).to(9)
                                    .foldLeft(List.empty[List[Int]]) {
                                            (result, y) => aux(k-1, n)(y :: selectedNums) match {
                                                                case Some(output) => result ::: output
                                                                case None => result
                                                            }       
                                                        }

                Some(result)

            }
        }

        // start the recursion
        aux(k, n)(Nil).getOrElse(List.empty[List[Int]])
        
    }
}