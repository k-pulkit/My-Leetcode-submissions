/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */

object Solution {

    /*
    * Takes @param: root
    * @returns: (local max, global max)
    */
    def helper(root: TreeNode): (Int, Int) = {
        if (root == null) {
            (0, 0)
        }
        else {
            // get left and right
            val left = root.left
            val right = root.right
            // 
            val (leftEdges, leftMax) = helper(left)
            val (rightEdges, rightMax) = helper(right)
            //
            val rootEdges = leftEdges + rightEdges
            val global = leftMax max rightMax max rootEdges

            (1 + (leftEdges max rightEdges), global)

        }
    }

    def diameterOfBinaryTree(root: TreeNode): Int = {

        helper(root)._2
        
    }
}