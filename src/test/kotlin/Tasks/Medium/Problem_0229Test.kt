package leetcode.tasks.medium

import kotlin.test.Test
import kotlin.test.assertEquals

class Problem_0229Test {
    @Test
    fun example1() {
        val sol = Problem_0229.Solution()
        val input = intArrayOf(3,2,3)
        val expected = listOf<Int>(3)
        val actual = sol.majorityElement(input)
        assertEquals(expected, actual)
    }

    @Test
    fun example2() {
        val sol = Problem_0229.Solution()
        val input = intArrayOf(1)
        val expected = listOf<Int>(1)
        val actual = sol.majorityElement(input)
        assertEquals(expected, actual)
    }

    @Test
    fun example3() {
        val sol = Problem_0229.Solution()
        val input = intArrayOf(1,2)
        val expected = listOf<Int>(1,2)
        val actual = sol.majorityElement(input)
        assertEquals(expected, actual)
    }

    @Test
    fun example1mine() {
        val sol = Problem_0229.Solution()
        val input = intArrayOf(3,3,3,3,2,2,1,4,5)
        val expected = listOf<Int>(3)
        val actual = sol.majorityElement(input)
        assertEquals(expected, actual)
    }

    @Test
    fun example2mine() {
        val sol = Problem_0229.Solution()
        val input = intArrayOf(3,3,3,3,2,2,2,2,5)
        val expected = listOf<Int>(3,2)
        val actual = sol.majorityElement(input)
        assertEquals(expected, actual)
    }

    @Test
    fun example3mine() {
        val sol = Problem_0229.Solution()
        val input = intArrayOf(3,3,3,3,3,3,3,3,3)
        val expected = listOf<Int>(3)
        val actual = sol.majorityElement(input)
        assertEquals(expected, actual)
    }

    @Test   // test 93/95
    fun example1wrong(){
        val sol = Problem_0229.Solution()
        val input = intArrayOf(2,1,1,3,1,4,5,6)
        val expected = listOf<Int>(1)
        val actual = sol.majorityElement(input)
        assertEquals(expected, actual)
        
    }
}