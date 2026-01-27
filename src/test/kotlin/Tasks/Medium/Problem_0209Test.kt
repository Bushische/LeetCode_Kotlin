package leetcode.tasks.medium

import kotlin.test.Test
import kotlin.test.assertEquals

class Problem_0209Test {
    @Test
    fun example1() {
        val sol = Problem_0209.Solution()
        val target = 7
        val input = intArrayOf(2, 3, 1, 2, 4, 3)
        val expected = 2
        val actual = sol.minSubArrayLen(target, input)
        assertEquals(expected, actual)
        /*      (2, 3, 1, 2, 4, 3)
            -> (0, 2, 5, 6, 8, 12, 15)  length:7
                l  r
            l = 0
            r = 1
            sum = 2
            length = 1
         */
    }

    fun example2() {
        val sol = Problem_0209.Solution()
        val target = 4
        val input = intArrayOf(1, 4, 4)
        val expected = 1
        val actual = sol.minSubArrayLen(target, input)
        assertEquals(expected, actual)
    }

    fun example3() {
        val sol = Problem_0209.Solution()
        val target = 11
        val input = intArrayOf(1,1,1,1,1,1,1,1)
        val expected = 0
        val actual = sol.minSubArrayLen(target, input)
        assertEquals(expected, actual)
    }
}
