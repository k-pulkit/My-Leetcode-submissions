/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */

object Solution {
    def hasCycle(head: ListNode): Boolean = {

        // Move the pointer at X speed
        def Xpointer (X: Int)(head: ListNode): ListNode = {
            if (X == 0) {
                head
            } else {
                if (head.next == null) null else Xpointer(X-1)(head.next)
            }
        }

        // create a fast and slow pointer
        type NxPointer = (ListNode) => ListNode
        val _2Xpointer: NxPointer = Xpointer(2)
        val _1Xpointer: NxPointer = Xpointer(1)
    
        def aux(fast: NxPointer, slow: NxPointer)(fastAt: ListNode, slowAt: ListNode): Boolean = {
            // println(s"$fastAt, $slowAt")
            if (fastAt == null) false 
            else if (fastAt == slowAt) true
            else aux(fast, slow)(fast(fastAt), slow(slowAt))
        }

        if (head==null) false
        else aux(_2Xpointer, _1Xpointer)(_2Xpointer(head), _1Xpointer(head))
        
    }
}