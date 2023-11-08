object Solution {

    def allPathsToTargetFrom(graph: Array[Array[Int]])(index: Int, traversed: List[Int]): List[List[Int]] = {
        if (index == graph.size-1) 
            List(traversed ::: index :: Nil)
        else {
            val localTargets = graph(index)
            localTargets.foldLeft(List.empty[List[Int]]) {
                (result, target) => result ::: allPathsToTargetFrom(graph)(target,  traversed ::: index :: Nil)
            }
        }
    }

    def allPathsSourceTarget(graph: Array[Array[Int]]): List[List[Int]] = {
        allPathsToTargetFrom(graph)(0, Nil)
    }
}