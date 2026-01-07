package leetcode.tasks.easy

import kotlin.test.Test
import kotlin.test.assertEquals

class Problem_0119Test {
    @Test
    fun examples() {
        val sol = Problem_0119.Solution()
        assertEquals(listOf(1), sol.getRow(0))
        assertEquals(listOf(1, 1), sol.getRow(1))
        assertEquals(listOf(1, 3, 3, 1), sol.getRow(3))
        assertEquals(listOf(1, 4, 6, 4, 1), sol.getRow(4))
    }
}
