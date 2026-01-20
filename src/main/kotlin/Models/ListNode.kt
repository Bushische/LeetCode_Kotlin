package leetcode.models

class ListNode(
    var `val`: Int,
) {
    var next: ListNode? = null

    companion object {
        /**
         * Convert the List<Int?> into ListNode
         */
        fun fromArray(nums: List<Int>): ListNode? {
            if (nums.size == 0) {
                return null
            }

            // create root
            var elem = nums[0]
            val head = ListNode(elem)

            var node = head
            var index = 1
            while (index < nums.count()) {
                elem = nums[index]
                val newNode = ListNode(elem)
                node.next = newNode
                node = newNode
                index++
            }

            return head
        }

        fun toArray(head: ListNode?): List<Int> {
            val list = mutableListOf<Int>()
            var node = head
            while (node != null) {
                list.add(node.`val`)
                node = node.next
            }

            return list.toList()
        }
    }
}
