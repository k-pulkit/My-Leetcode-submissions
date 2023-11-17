object Solution {

    // Function to find cross product of list of lists.
    def cProd[T](in: Iterator[List[T]]): List[List[T]] =
        in.foldRight(List(List.empty[T])) {
            // keep appending elements in current list to result LISTS
            for {word <- _ ; sentence <- _} yield word :: sentence
        }


        def pyramidTransition(bottom: String, allowed: List[String]): Boolean = {

            // mapping of every two blocks to the possible third block on top
            val allowedMap: Map[String, List[Char]] = allowed.map(_.splitAt(2)).groupMap(x => x._1)(x => x._2.charAt(0))

            // helper function
            def aux(bottom: List[Char], allowedMap: Map[String, List[Char]]): Boolean = 
                bottom match {
                    case Nil => false          // in case the new layer cannot be created
                    case head :: Nil => true   // successfully reached the top block
                    case _ => 
                        // using cross product, find all possible possible bottoms
                        val nextBottoms: List[List[Char]] = cProd(bottom.sliding(2, 1).map((x: List[Char]) => allowedMap.getOrElse(x.mkString, Nil)))
                        // checkfor each possible bottom until we find a solution, and then stop
                        nextBottoms.to(LazyList).exists(p => aux(p, allowedMap))
                }
            
            aux(bottom.toList, allowedMap)
        }
}