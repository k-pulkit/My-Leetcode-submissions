/**
 * Definition for a Node.
 * class Node(var _value: Int) {
 *   var value: Int = _value
 *   var left: Node = null
 *   var right: Node = null
 *   var next: Node = null
 * }
 */

import scala.collection.immutable.{Vector, List}

object Solution {
    def connect(root: Node): Node = {

        def update(mem: Vector[List[Node]], index: Int, element: Node): Vector[List[Node]] = {
            if (mem.size-1 < index) mem :+ List(element)
            else {
                // println(s"Updating ${mem(index).head.value}.next to ${element.value}")
                mem(index).head.next = element
                mem.updated(index, element :: mem(index))
            }
        }

        def isLeaf(element: Node): Boolean = (element.left == null) && (element.right == null)

        def aux(root: Node, level: Int)(mem: Vector[List[Node]]): Vector[List[Node]] = {
            val currentLevel = level+1
            if (isLeaf(root)) mem
            else {
                // Left nodes add new element to memory vector
                val left = root.left
                val m1 = aux(left, currentLevel)(update(mem, currentLevel, left))
                // right elements use head of the mem vector for their level to update their next pointer
                // then attach themselves as new head
                val right = root.right
                aux(right, currentLevel)(update(m1, currentLevel, right))
            }
        }

        // modify the tree
        if (root != null && !isLeaf(root)) aux(root, 0)(Vector(List(root)))
        root
        
    }
}