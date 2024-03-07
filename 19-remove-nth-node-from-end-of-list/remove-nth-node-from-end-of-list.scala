/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
import scala.collection.mutable.ArrayBuffer

object Solution {
    def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
        // This array will hold the elements of the small list as we go through it
        var nodeStore = new ArrayBuffer[ListNode]()

        // SideEffect function to update array buffer
        def traverse(node: ListNode)(store: ArrayBuffer[ListNode]): Unit = {
            if (node != null) {
                store += node
                traverse(node.next)(store)
            }
        }

        // update array buffer
        traverse(head)(nodeStore)

        // size of LL
        val sz = nodeStore.size

        // Which element index we need to remove from start
        val i = sz - n

        // first elem
        if (i==0) head.next 
        // last elem
        else if (n == 1 && sz == 1) head.next
        else if (n == 1 && sz == 1) {
            nodeStore(i-1).next = null
            head
        }
        // default case
        else {
            nodeStore(i-1).next = nodeStore(i).next
            head
        }
        
    }
}