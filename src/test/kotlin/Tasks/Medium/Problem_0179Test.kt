package leetcode.tasks.medium

import kotlin.test.Test
import kotlin.test.assertEquals

class Problem_0179Test {
    @Test
    fun example1() {
        val sol = Problem_0179.Solution()

        val input = intArrayOf(10, 2)
        val expected = "210"
        val actual = sol.largestNumber(input)
        assertEquals(expected, actual)
    }

    @Test
    fun example2() {
        val sol = Problem_0179.Solution()

        val input = intArrayOf(3, 30, 34, 5, 9)
        val expected = "9534330"
        val actual = sol.largestNumber(input)
        assertEquals(expected, actual)
    }

    @Test
    fun example3() {
        val sol = Problem_0179.Solution()

        val input = intArrayOf(0, 0, 0, 0)
        val expected = "0"
        val actual = sol.largestNumber(input)
        assertEquals(expected, actual)
    }

    @Test
    fun example4() {
        val sol = Problem_0179.Solution()

        val input = intArrayOf(34323, 3432)
        val expected = "343234323"
        val actual = sol.largestNumber(input)
        assertEquals(expected, actual)
    }
    
}
