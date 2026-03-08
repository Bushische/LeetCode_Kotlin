package leetcode.tasks.medium

import leetcode.models.ListNode
import kotlin.test.Test
import kotlin.test.assertEquals

class Problem_0237Test {
    @Test
    fun example1() {
        val sol = Problem_0237.Solution()
        val listNums = listOf<Int>(4,5,1,9)
        val searchVal = 5
        val expected = listOf<Int>(4,1,9)
        val list = ListNode.fromArray(listNums)
        val node = ListNode.findNode(list, searchVal)
        sol.deleteNode(node)
        val actual = ListNode.toArray(list)
        assertEquals(expected, actual)
    }

    @Test
    fun example2() {
        val sol = Problem_0237.Solution()
        val listNums = listOf<Int>(4,5,1,9)
        val searchVal = 1
        val expected = listOf<Int>(4,5,9)
        val list = ListNode.fromArray(listNums)
        val node = ListNode.findNode(list, searchVal)
        sol.deleteNode(node)
        val actual = ListNode.toArray(list)
        assertEquals(expected, actual)
    }
}