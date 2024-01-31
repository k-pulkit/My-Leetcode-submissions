/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {

    implicit class TreeOps(tree: TreeNode) {
        def isLeaf: Boolean = {
                tree.left == null && tree.right == null
            }
    }
    
    def getLeafSeq(root: TreeNode): List[Int] = {
        if (root == null) Nil
        else if (root.isLeaf) root.value :: Nil
        else {
            val left = root.left
            val right = root.right
            getLeafSeq(left) ::: getLeafSeq(right)
        }
    }

    def leafSimilar(root1: TreeNode, root2: TreeNode): Boolean = {
        val s1 = getLeafSeq(root1)
        val s2 = getLeafSeq(root2)
        // println(s1)
        // println(s2)
        // println(s1.zip(s2))
        if (s1.length != s2.length) false
        else s1.zip(s2).map {case (x, y) => x==y} .reduce(_ && _)
    }
}