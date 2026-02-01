package leetcode.tasks.medium

import kotlin.test.Test
import kotlin.test.assertEquals

class Problem_0215Test {
    @Test
    fun example1() {
        val sol = Problem_0215.Solution()
        val input = intArrayOf(3, 2, 1, 5, 6, 4)
        val k = 2
        val expected = 5
        val actual = sol.findKthLargest(input, k)
        assertEquals(expected, actual)
    }

    @Test
    fun example2() {
        val sol = Problem_0215.Solution()
        val input = intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6)
        val k = 4
        val expected = 4
        val actual = sol.findKthLargest(input, k)
        assertEquals(expected, actual)
    }

    @Test
    fun example3() {
        val sol = Problem_0215.Solution()
        val input = intArrayOf(3, 2, 3, 1, 1, 1, 1, 1, 1)
        val k = 4
        val expected = 1
        val actual = sol.findKthLargest(input, k)
        assertEquals(expected, actual)
    }

    @Test
    fun wrongCase1() {
        val sol = Problem_0215.Solution()
        val input = intArrayOf(2, 1)
        val k = 1
        val expected = 2
        val actual = sol.findKthLargest(input, k)
        assertEquals(expected, actual)
    }

    // timeout error with array with many 1s and k=5000

    @Test
    fun wrongCase2() { // 37/45
        val sol = Problem_0215.Solution()
        val input = intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6)
        val k = 20
        val expected = 2
        val actual = sol.findKthLargest(input, k)
        assertEquals(expected, actual)
    }
}
