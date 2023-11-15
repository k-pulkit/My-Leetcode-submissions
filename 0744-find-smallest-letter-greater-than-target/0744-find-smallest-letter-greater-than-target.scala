object Solution {
    def nextGreatestLetter(letters: Array[Char], target: Char): Char = {
        letters.to(LazyList).dropWhile(p => p <= target).headOption match {
            case Some(char) => char
            case None => letters.head
        }
    }
}