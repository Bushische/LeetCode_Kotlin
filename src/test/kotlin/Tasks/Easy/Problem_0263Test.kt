package leetcode.tasks.easy

import kotlin.test.Test
import kotlin.test.assertEquals

class Problem_0263Test {
    @Test
    fun example1() {
        val sol = Problem_0263.Solution()
        val input = 6
        val expected = true
        val actual = sol.isUgly(input)
        assertEquals(expected, actual)
    }

    @Test
    fun example2() {
        val sol = Problem_0263.Solution()
        val input = 1
        val expected = true
        val actual = sol.isUgly(input)
        assertEquals(expected, actual)
    }

    @Test 
    fun example3() {
        val sol = Problem_0263.Solution()
        val input = 14
        val expected = false
        val actual = sol.isUgly(input)
        assertEquals(expected, actual)
    }
}
