/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def maxDepth(root: TreeNode): Int = {

        // assume helper function returns the depth for the root node
        def helper(root: TreeNode): Int = {
            if (root == null) {
                0
            } else {
                val left = root.left
                val right = root.right
                1 + Math.max(helper(left), helper(right)) // int
            }
        }

        helper(root)
        
    }
}