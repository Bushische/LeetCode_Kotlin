package leetcode.tasks.medium

import leetcode.models.ListNode

class Problem_0143 {
    /* 143. Reorder List
    URL: https://leetcode.com/problems/reorder-list/description/

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Example 1:
Input: head = [1,2,3,4]
Output: [1,4,2,3]

Example 2:
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]

Constraints:
The number of nodes in the list is in the range [1, 5 * 10^4].
1 <= Node.val <= 1000
     */

    class Solution {
        /* IDEA: build a reverse list
         * move from the beginning for both lists create a result list
         * (modify the first list)
         *
         * Bruteforce:
         * [1,2,3,4]
         * [4,3,2,1] <- reverse
         * 1,4 -> 1,4
         * 2,3 -> 1,4,2,3
         * stop, as ref1.next = ref2 OR ref2.next = ref1
         *
         * [1,2,3,4,5]
         * [5,4,3,2,1] <- reverse
         * 1,5 -> 1,5
         * 2,4 -> 1,5,2,4
         * 3,3 -> 1,5,2,4,3 !! Spec case
         * stop as a spec case
         *
         * BUT: You may not modify the values in the list's nodes.
         * SO, let's work with references
         *
         */

        fun reorderList(head: ListNode?) {
            // 1. make a reverse list
            var reversedHead = getReversedList(head)
            var listNode = head
            var reversedNode = reversedHead

            while ((listNode != null) && (reversedNode != null)&&
                (listNode != reversedNode.refNode) && // spec case
                (listNode.next != reversedNode.refNode) &&
                (listNode != reversedNode.refNode?.next)
            ) {
                val nextListNode = listNode.next

                listNode.next = reversedNode.refNode
                reversedNode.refNode?.next = nextListNode

                listNode = nextListNode
                reversedNode = reversedNode.next

                // move condition here
                if (listNode?.next == reversedNode?.refNode) {
                    listNode?.next = null
                }
                // spec case
                if (listNode == reversedNode?.refNode) {
                    listNode?.next = null
                    listNode = null
                }
            }
        }

        /**
         * List of links to the original list elements
         */
        private class RefListNode(
            val refNode: ListNode?,
            val next: RefListNode?,
        )

        private fun getReversedList(head: ListNode?): RefListNode? {
            if (head == null) {
                return null
            }

            var buffer: RefListNode? = null
            var node = head
            while (node != null) {
                val nb = RefListNode(node, buffer)
                buffer = nb

                node = node.next
            }
            return buffer
        }
    }
}
