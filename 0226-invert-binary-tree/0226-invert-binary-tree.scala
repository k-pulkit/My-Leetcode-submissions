/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def invertTree(root: TreeNode): TreeNode = {
        if (root == null)                                    // node is null
            null
        else if (root.left == null && root.right == null)    // leaf node
            root
        else {
            val left = root.left
            val right = root.right
            TreeNode(root.value, invertTree(right), invertTree(left))
        }
    }
}