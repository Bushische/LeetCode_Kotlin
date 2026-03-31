package leetcode.tasks.easy

import kotlin.test.Test
import kotlin.test.assertEquals

class Problem_0258Test {
    @Test
    fun example1() {
        val sol = Problem_0258.Solution()
        val input = 38
        val expected = 2
        val actual = sol.addDigits(input)
        assertEquals(expected, actual)
    }

    @Test
    fun example2() {
        val sol = Problem_0258.Solution()
        val input = 0
        val expected = 0
        val actual = sol.addDigits(input)
        assertEquals(expected, actual)
    }

    // ------ mine
    @Test
    fun example1mine(){
        val sol = Problem_0258.Solution()
        val input = 12345
        val expected = 6
        val actual = sol.addDigits(input)
        assertEquals(expected, actual)
    }
}
