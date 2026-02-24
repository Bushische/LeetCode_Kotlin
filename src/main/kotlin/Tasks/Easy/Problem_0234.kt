package leetcode.tasks.easy

import leetcode.models.ListNode

class Problem_0234 {
    /* 234. Palindrome Linked List
    URL: https://leetcode.com/problems/palindrome-linked-list/

Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

Example 1:
Input: head = [1,2,2,1]
Output: true

Example 2:
Input: head = [1,2]
Output: false

Constraints:
The number of nodes in the list is in the range [1, 10^5].
0 <= Node.val <= 9

Follow up: Could you do it in O(n) time and O(1) space?
     */

    /**
     * class ListNode(var `val`: Int) {
     *     var next: ListNode? = null
     * }
     */
    class Solution {
        /* IDEA: use two references
         *  * one - move by next
         *  * two - move by next next
         * Move them while two.next or two.next.next != null
         * when the two. is null, the one should be near the center
         *  * if two.next == null, then the one stays on the last element in the first half (and total number is odd)
         *  * if two.next.next == null, then the one stays on the middle element, and the first half is on left
         *
         * IDEA details: just revert first half of the list. After finding the center, check elements to left and to right
         */
        private fun log(
            message: String,
            one: ListNode?,
            two: ListNode?,
        ) {
            // println("$message: one=(${one?.`val`}, ${one?.next?.`val`}) two=(${two?.`val`}, ${two?.next?.`val`})")
        }

        fun isPalindrome(head: ListNode?): Boolean {
            // edge case: one elements
            if (head?.next == null) return true
            // edge case: two elements
            if (head.next?.next == null) return (head.`val` == head.next?.`val`)

            var one = head
            var two = head
            var onePrev: ListNode? = null // previous element for one
            while ((two != null) && (two.next != null) && (two.next?.next != null)) {
                log("while iteration", one, two)
                // move the fast reference
                two = two.next?.next
                log("while iteration ass1", one, two)
                // revert the first half
                val oneOld = one
                one = one?.next
                oneOld?.next = onePrev
                onePrev = oneOld
                log("while iteration end", one, two)
            }
            log("Stop", one, two)
            // one?.next = onePrev

            // now there are two situations are possible
            if (two?.next == null) { // just skip the middle element
                two = one?.next
                one = onePrev
            } else if (two.next?.next == null) {
                two = one?.next
                one?.next = onePrev
            }
            log("Reassignment", one, two)

            // pass in parallel
            while ((one != null) && (two != null) && (one.`val` == two.`val`)) {
                one = one.next
                two = two.next
            }
            log("Finish", one, two)

            return (one == null) && (two == null)
        }
    }
    // 1,2,3,4,5,6,7,8      two.next == null
    //       ^     ^
    // 1,2,3,4,5,6,7,8,9    two.next.next == null
    //         ^       ^
}
