package leetcode.tasks.medium

import leetcode.models.ListNode
import kotlin.test.Test
import kotlin.test.assertEquals

class Problem_0143Test {
    @Test
    fun examples() {
        val sol = Problem_0143.Solution()

        // case 1
        var input = listOf<Int>(1, 2, 3, 4)
        var expected = listOf<Int>(1, 4, 2, 3)
        var inputList = ListNode.fromArray(input)
        sol.reorderList(inputList)
        var actual = ListNode.toArray(inputList)
        assertEquals(expected, actual)

        // case 2
        input = listOf<Int>(1, 2, 3, 4, 5)
        expected = listOf<Int>(1, 5, 2, 4, 3)
        inputList = ListNode.fromArray(input)
        sol.reorderList(inputList)
        actual = ListNode.toArray(inputList)
        assertEquals(expected, actual)

        // case 3
        input = listOf<Int>(1, 2)
        expected = listOf<Int>(1, 2)
        inputList = ListNode.fromArray(input)
        sol.reorderList(inputList)
        actual = ListNode.toArray(inputList)
        assertEquals(expected, actual)
    }
}
