package leetcode.tasks.easy

import kotlin.test.Test
import kotlin.test.assertEquals

class Problem_0231Test {
    @Test
    fun example1() {
        val sol = Problem_0231.Solution()
        val input = 1
        val expected = true
        val actual = sol.isPowerOfTwo(input)
        assertEquals(expected, actual)
    }

    @Test
    fun example2() {
        val sol = Problem_0231.Solution()
        val input = 16
        val expected = true
        val actual = sol.isPowerOfTwo(input)
        assertEquals(expected, actual)
    }

    @Test
    fun example3() {
        val sol = Problem_0231.Solution()
        val input = 3
        val expected = false
        val actual = sol.isPowerOfTwo(input)
        assertEquals(expected, actual)
    }

    @Test
    fun example1mine() {
        val n = -1
        val n2 = -2
        val min1 = Int.MIN_VALUE+1
        val min = Int.MIN_VALUE
        println("-1 => ${Integer.toBinaryString(n)}")
        println("-2 => ${Integer.toBinaryString(n2)}")
        println("-min_max+1 => ${Integer.toBinaryString(min1)}")
        println("-min_max => ${Integer.toBinaryString(min)}")
    }
}
