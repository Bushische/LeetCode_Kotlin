package leetcode.tasks.medium

import kotlin.test.Test
import kotlin.test.assertEquals

class Problem_0227Test {
    @Test
    fun example1() {
        val sol = Problem_0227.Solution()
        val input = "3+2*2"
        val expected = 7
        val actual = sol.calculate(input)
        assertEquals(expected, actual)
    }

    @Test
    fun example2() {
        val sol = Problem_0227.Solution()
        val input = " 3/2 "
        val expected = 1
        val actual = sol.calculate(input)
        assertEquals(expected, actual)
    }

    @Test
    fun example3() {
        val sol = Problem_0227.Solution()
        val input = " 3+5 / 2 "
        val expected = 5
        val actual = sol.calculate(input)
        assertEquals(expected, actual)
    }

    @Test
    fun example1mine() {
        val sol = Problem_0227.Solution()
        val input = "1"
        val expected = 1
        val actual = sol.calculate(input)
        assertEquals(expected, actual)
    }

    @Test
    fun example2mine() {
        val sol = Problem_0227.Solution()
        val input = "5/2*4"
        val expected = 8
        val actual = sol.calculate(input)
        assertEquals(expected, actual)
    }
}