/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def rightSideView(root: TreeNode): List[Int] = {
        if (root == null)
            Nil
        else if (root.left==null && root.right==null) 
            root.value :: Nil
        else {
            val left = rightSideView(root.left)
            val right = rightSideView(root.right)
            // combine the views            
            root.value :: (right ::: left.drop(right.size))
        }

    }
}