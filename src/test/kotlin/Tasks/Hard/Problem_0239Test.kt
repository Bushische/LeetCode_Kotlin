package leetcode.tasks.hard

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Problem_0239Test {
    @Test
    fun example1() {
        val sol = Problem_0239.Solution()
        val input = intArrayOf(1, 3, -1, -3, 5, 3, 6, 7)
        val k = 3
        val expected = intArrayOf(3, 3, 5, 5, 6, 7)
        val actual = sol.maxSlidingWindow(input, k)
        // println(expected.joinToString(",") )
        // println(actual.joinToString(",") )
        assertTrue(actual.contentEquals(expected))
    }

    @Test
    fun example2() {
        val sol = Problem_0239.Solution()
        val input = intArrayOf(1)
        val k = 1
        val expected = intArrayOf(1)
        val actual = sol.maxSlidingWindow(input, k)
        // println(expected.joinToString(",") )
        // println(actual.joinToString(",") )
        assertTrue(actual.contentEquals(expected))
    }
}
