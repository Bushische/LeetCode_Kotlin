package leetcode.tasks.hard

import kotlin.test.Test
import kotlin.test.assertEquals

class Problem_0233Test {
    @Test
    fun example1() {
        val sol = Problem_0233.Solution()
        val input = 13
        val expected = 6
        val actual = sol.countDigitOne(input)
        assertEquals(expected, actual)
    }

    @Test
    fun example2() {
        val sol = Problem_0233.Solution()
        val input = 0
        val expected = 0
        val actual = sol.countDigitOne(input)
        assertEquals(expected, actual)
    }

    @Test
    fun example1mine() {
        val sol = Problem_0233.Solution()
        val input = 130
        val expected = 64
        val actual = sol.countDigitOne(input)
        assertEquals(expected, actual)
    }

    @Test
    fun example2mine() {
        val sol = Problem_0233.Solution()
        val input = 99
        val expected = 20
        val actual = sol.countDigitOne(input)
        assertEquals(expected, actual)
    }
}
