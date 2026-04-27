package leetcode.tasks.easy

import kotlin.test.Test
import kotlin.test.assertEquals

class Problem_0219Test {
    @Test
    fun example1() {
        val sol = Problem_0219.Solution()
        val input = intArrayOf(1, 2, 3, 1)
        val k = 3
        val expected = true
        val actual = sol.containsNearbyDuplicate(input, k)
        assertEquals(expected, actual)
    }

    @Test
    fun example2() {
        val sol = Problem_0219.Solution()
        val input = intArrayOf(1,0,1,1)
        val k = 1
        val expected = true
        val actual = sol.containsNearbyDuplicate(input, k)
        assertEquals(expected, actual)
    }

    @Test
    fun example3() {
        val sol = Problem_0219.Solution()
        val input = intArrayOf(1,2,3,1,2,3)
        val k = 2
        val expected = false
        val actual = sol.containsNearbyDuplicate(input, k)
        assertEquals(expected, actual)
    }
}
