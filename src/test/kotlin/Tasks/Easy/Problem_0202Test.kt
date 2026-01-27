package leetcode.tasks.easy

import kotlin.test.Test
import kotlin.test.assertEquals

class Problem_0202Test {
    @Test
    fun examples() {
        val sol = Problem_0202.Solution()

        var input = 2
        var expected = false
        var actual = sol.isHappy(input)
        assertEquals(expected, actual)

        input = 19
        expected = true
        actual = sol.isHappy(input)
        assertEquals(expected, actual)

        
    }
}