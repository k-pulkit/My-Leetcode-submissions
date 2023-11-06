object Solution {
    def buildArray(target: Array[Int], n: Int): List[String] = {

        def aux(target: List[Int], n: Int)(i: Int): List[String] = {
            if (i > n || target == Nil) {
                Nil
            } 
            else {
                val x = 
                    if (i == target.head) 
                        List("Push") ::: aux(target.tail, n)(i+1)
                    else
                        List("Push", "Pop") ::: aux(target, n)(i+1)
                x
            }
        }

        aux(target.toList, n)(1)

    }
}