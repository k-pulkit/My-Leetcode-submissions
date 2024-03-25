object Solution {
    def mergeAlternately(word1: String, word2: String): String = {

        def aux(word1: List[Char], word2: List[Char]): List[Char] = {
            (word1, word2) match {
                case (Nil, Nil) => Nil
                case (head1 :: tail1, Nil) => head1 :: aux(tail1, Nil)
                case (Nil, head2 :: tail2) => head2 :: aux(Nil, tail2)
                case (head1 :: tail1, head2 :: tail2) => head1 :: head2 :: aux(tail1, tail2)
            }
        }

        aux(word1.toList, word2.toList).mkString("")
        
    }
}