/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */

object Solution {
    def maxAncestorDiff(root: TreeNode): Int = {

        var result: List[Int] = List.empty[Int]

        def aux(root: TreeNode, maxSeen: Int, minSeen: Int): Int = {

            if (root == null) {
                // means we have reached a treeNode
                maxSeen - minSeen
            }
            else {
                // what is the root value of current node
                val value = root.value
                // update max and min based on the value of 
                val max = maxSeen max value
                val min = minSeen min value
                // traverse the tree depth first using recursion
                Math.max(aux(root.left, max, min), aux(root.right, max, min))
            }

        }

        // start iterations
        aux(root, root.value, root.value)
        
    }
}