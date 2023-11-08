/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */

object Solution {

    implicit class TreeSyntax(root: TreeNode) {
        def isLeaf = root.left == null && root.right == null 
    }

    def minDepth(root: TreeNode): Int = {

        // assume helper function returns the depth for the root node
        def helper(root: TreeNode)(depth: Int): Int = {
            if (root.isLeaf) {
                depth+1
            } else {
                val leftDepth = if (root.left == null) Int.MaxValue else helper(root.left)(depth+1)
                val rightDepth = if (root.right == null) Int.MaxValue else helper(root.right)(depth+1)
                Math.min(leftDepth, rightDepth) 
            }
        }

        if (root==null) 0 else helper(root)(0)
        
    }
}