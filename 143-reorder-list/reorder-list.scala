/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */

import scala.collection.mutable.Stack

object Solution {
    def reorderList(head: ListNode): Unit = {
        var stack = Stack.empty[ListNode]
        var curr = head
        while(curr != null) {
            stack.push(curr)
            curr = curr.next
        }

        curr = head
        for (i <- (1 to stack.size/2)) {
            val n = curr.next
            val top = stack.pop()
            top.next = n
            curr.next = top
            curr = n
        }
        curr.next = null

        ()
    }
}