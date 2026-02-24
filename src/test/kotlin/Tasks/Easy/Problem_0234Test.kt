package leetcode.tasks.easy

import leetcode.models.ListNode
import kotlin.test.Test
import kotlin.test.assertEquals

class Problem_0234Test {
    @Test
    fun example1() {
        val sol = Problem_0234.Solution()
        val input = listOf<Int>(1, 2, 2, 1)
        val expected = true
        val head = ListNode.fromArray(input)
        val actual = sol.isPalindrome(head)
        assertEquals(expected, actual)
    }

    @Test
    fun example2() {
        val sol = Problem_0234.Solution()
        val input = listOf<Int>(1, 2)
        val expected = false
        val head = ListNode.fromArray(input)
        val actual = sol.isPalindrome(head)
        assertEquals(expected, actual)
    }

    @Test
    fun example1mine() {
        val sol = Problem_0234.Solution()
        val input = listOf<Int>(1)
        val expected = true
        val head = ListNode.fromArray(input)
        val actual = sol.isPalindrome(head)
        assertEquals(expected, actual)
    }

    @Test
    fun example2mine() {
        val sol = Problem_0234.Solution()
        val input = listOf<Int>(1, 1)
        val expected = true
        val head = ListNode.fromArray(input)
        val actual = sol.isPalindrome(head)
        assertEquals(expected, actual)
    }

    @Test
    fun example3mine() {
        val sol = Problem_0234.Solution()
        val input = listOf<Int>(1, 2, 1)
        val expected = true
        val head = ListNode.fromArray(input)
        val actual = sol.isPalindrome(head)
        assertEquals(expected, actual)
    }
}
