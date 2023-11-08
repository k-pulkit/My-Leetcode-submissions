import scala.collection.mutable.HashSet

object Solution {
    def findWinners(matches: Array[Array[Int]]): List[List[Int]] = {
        
        var winners = HashSet.empty[Int]
        var loosers = HashSet.empty[Int]
        var bigLoosers = HashSet.empty[Int]

        // winner - loosers => only winners
        // loosers - bigLoosers => lost one time

        for (aMatch <- matches) {
            val winner = aMatch(0)
            val looser = aMatch(1)
            winners.add(winner)
            if (loosers(looser)) bigLoosers.add(looser)
            loosers.add(looser)
        }

        val onlyWinners = winners diff loosers
        val oneTimeLost = loosers diff bigLoosers

        List(onlyWinners.toList.sorted, oneTimeLost.toList.sorted)
        
    }
}