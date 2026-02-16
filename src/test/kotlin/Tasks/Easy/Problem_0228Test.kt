package leetcode.tasks.easy

import kotlin.test.Test
import kotlin.test.assertEquals

class Problem_0228Test {
    @Test
    fun example1() {
        val sol = Problem_0228.Solution()
        val nums = intArrayOf(0, 1, 2, 4, 5, 7)
        val expected = listOf<String>("0->2", "4->5", "7")
        val actual = sol.summaryRanges(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun example2() {
        val sol = Problem_0228.Solution()
        val nums = intArrayOf(0, 2, 3, 4, 6, 8, 9)
        val expected = listOf<String>("0", "2->4", "6", "8->9")
        val actual = sol.summaryRanges(nums)
        assertEquals(expected, actual)
    }
}
