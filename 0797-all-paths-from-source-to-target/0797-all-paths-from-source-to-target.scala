object Solution {

    def allPathsToTargetFrom(graph: Array[Array[Int]])(index: Int): List[List[Int]] = {
        if (index == graph.size-1) 
            List(index :: Nil)
        else {
            // iterate through local targets
            graph(index).foldLeft(List.empty[List[Int]]) {
                // for result from each local target call, add index to refect it as parent
                (result, target) => result ::: allPathsToTargetFrom(graph)(target).map(x => index :: x) 
            }
        }
    }

    def allPathsSourceTarget(graph: Array[Array[Int]]): List[List[Int]] = {
        allPathsToTargetFrom(graph)(0)
    }
}