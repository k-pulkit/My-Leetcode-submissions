/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
    def reverseList(head: ListNode): ListNode = {

        def aux(remainder: ListNode)(carry: ListNode): ListNode = {
            if (remainder == null) {
                carry
            } else {
                val head: Int = remainder.x
                val tail: ListNode = remainder.next

                aux(tail)(ListNode(head, carry))
            }
        }

        aux(head)(null)

    }
}