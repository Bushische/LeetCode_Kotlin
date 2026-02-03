package leetcode.tasks.medium

import kotlin.test.Test
import kotlin.test.assertEquals

class Problem_0221Test {
    @Test
    fun example1() {
        val sol = Problem_0221.Solution()
        val input =
            arrayOf(
                charArrayOf('1', '0', '1', '0', '0'),
                charArrayOf('1', '0', '1', '1', '1'),
                charArrayOf('1', '1', '1', '1', '1'),
                charArrayOf('1', '0', '0', '1', '0'),
            )
        val expected = 4
        val actual = sol.maximalSquare(input)
        assertEquals(expected, actual)
    }

    @Test
    fun example2() {
        val sol = Problem_0221.Solution()
        val input =
            arrayOf(
                charArrayOf('0', '1'),
                charArrayOf('1', '0'),
            )
        val expected = 1
        val actual = sol.maximalSquare(input)
        assertEquals(expected, actual)
    }

    @Test
    fun example3() {
        val sol = Problem_0221.Solution()
        val input =
            arrayOf(
                charArrayOf('0'),
            )
        val expected = 0
        val actual = sol.maximalSquare(input)
        assertEquals(expected, actual)
    }

    @Test
    fun example1mine() {
        val sol = Problem_0221.Solution()
        val input =
            arrayOf(
                charArrayOf('1', '0', '1', '0', '0'),
                charArrayOf('1', '0', '1', '1', '1'),
                charArrayOf('1', '1', '1', '1', '1'),
                charArrayOf('0', '1', '1', '1', '1'),
            )
        val expected = 9
        val actual = sol.maximalSquare(input)
        assertEquals(expected, actual)
    }

    @Test // 61/81
    fun example1wrong() {
        val sol = Problem_0221.Solution()
        val input =
            arrayOf(
                charArrayOf('1', '1', '1', '1', '1', '1', '1', '1'),
                charArrayOf('1', '1', '1', '1', '1', '1', '1', '0'),
                charArrayOf('1', '1', '1', '1', '1', '1', '1', '0'),
                charArrayOf('1', '1', '1', '1', '1', '0', '0', '0'),
                charArrayOf('0', '1', '1', '1', '1', '0', '0', '0'),
            )
        val expected = 16
        val actual = sol.maximalSquare(input)
        assertEquals(expected, actual)
    }

    @Test // 74/81
    fun example2wrong() {
        val sol = Problem_0221.Solution()
        val input =
            arrayOf(
                charArrayOf('0', '0', '0', '1'),
                charArrayOf('1', '1', '0', '1'),
                charArrayOf('1', '1', '1', '1'),
                charArrayOf('0', '1', '1', '1'),
                charArrayOf('0', '1', '1', '1'),
            )
        val expected = 9
        val actual = sol.maximalSquare(input)
        assertEquals(expected, actual)
    }
}
