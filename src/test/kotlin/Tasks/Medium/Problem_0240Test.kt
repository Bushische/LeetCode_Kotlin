package leetcode.tasks.medium

import kotlin.test.Test
import kotlin.test.assertEquals

class Problem_0240Test {
    @Test
    fun example1() {
        val sol = Problem_0240.Solution()
        val input =
            arrayOf(
                intArrayOf(1, 4, 7, 11, 15),
                intArrayOf(2, 5, 8, 12, 19),
                intArrayOf(3, 6, 9, 16, 22),
                intArrayOf(10, 13, 14, 17, 24),
                intArrayOf(18, 21, 23, 26, 30),
            )
        val target = 5
        val expected = true
        val actual = sol.searchMatrix(input, target)
        assertEquals(expected, actual)
    }

    @Test
    fun example2() {
        val sol = Problem_0240.Solution()
        val input =
            arrayOf(
                intArrayOf(1, 4, 7, 11, 15),
                intArrayOf(2, 5, 8, 12, 19),
                intArrayOf(3, 6, 9, 16, 22),
                intArrayOf(10, 13, 14, 17, 24),
                intArrayOf(18, 21, 23, 26, 30),
            )
        val target = 20
        val expected = false
        val actual = sol.searchMatrix(input, target)
        assertEquals(expected, actual)
    }
}
