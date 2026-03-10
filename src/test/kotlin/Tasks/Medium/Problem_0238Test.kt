package leetcode.tasks.medium

import kotlin.test.Test
import kotlin.test.assertTrue

class Problem_0238Test {
    @Test
    fun example1() {
        val sol = Problem_0238.Solution()
        val input = intArrayOf(1, 2, 3, 4)
        val expected = intArrayOf(24, 12, 8, 6)
        val actual = sol.productExceptSelf(input)
        assertTrue(expected.contentEquals(actual))
    }

    @Test
    fun example2() {
        val sol = Problem_0238.Solution()
        val input = intArrayOf(-1,1,0,-3,3)
        val expected = intArrayOf(0,0,9,0,0)
        val actual = sol.productExceptSelf(input)
        assertTrue(expected.contentEquals(actual))
    }

    @Test   // edge case with two zeros
    fun example1mine() {
        val sol = Problem_0238.Solution()
        val input = intArrayOf(-1,1,0,-3,0)
        val expected = intArrayOf(0,0,0,0,0)
        val actual = sol.productExceptSelf(input)
        assertTrue(expected.contentEquals(actual))
    }

    @Test   // test 21 / 24
    fun example1wrong() {
        val sol = Problem_0238.Solution()
        val input = intArrayOf(1, 0)
        val expected = intArrayOf(0, 1)
        val actual = sol.productExceptSelf(input)
        assertTrue(expected.contentEquals(actual))
    }
}
