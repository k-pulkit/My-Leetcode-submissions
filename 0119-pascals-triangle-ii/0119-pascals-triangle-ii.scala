import scala.collection.mutable.Map

object Solution {
    def getRow(rowIndex: Int): List[Int] = {

        val cache: Map[(Int, Int), Int] = Map((0, 0) -> 1)
        
        def getRowCol(rowIndex: Int, colIndex: Int): Int = {

            if (colIndex == 0 || colIndex == rowIndex) {
                1   // output is 1
            }
            else if (cache.contains((rowIndex, colIndex))) {
                cache((rowIndex, colIndex))  // cache hit
            }
            else {
                val result = getRowCol(rowIndex-1, colIndex-1) + getRowCol(rowIndex-1, colIndex)
                cache((rowIndex, colIndex)) = result
                result // output 
            }

        }

    // Return a list of individual elements
    0.to(rowIndex).map(getRowCol(rowIndex, _)).toList
    
    }
}