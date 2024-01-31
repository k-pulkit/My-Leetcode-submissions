/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def rangeSumBST(root: TreeNode, low: Int, high: Int): Int = {
        if (root == null) {
            0
        } else {
            val x = if (root.value >= low && root.value <= high) root.value else 0
            x + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high)
        }
        
    }
}