package leetcode.tasks.medium

import kotlin.test.Test
import kotlin.test.assertEquals

class Problem_0167Test {
    @Test
    fun examples() {
        val sol = Problem_0167.Solution()

        // case 1
        var import = intArrayOf(2, 7, 11, 15)
        var target = 9
        var expected = intArrayOf(1, 2)
        var actual = sol.twoSum(import, target)
        assert(expected.contentEquals(actual))

        // case 2
        import = intArrayOf(2,3,4)
        target = 6
        expected = intArrayOf(1, 3)
        actual = sol.twoSum(import, target)
        assert(expected.contentEquals(actual))

        // case 3
        import = intArrayOf(-1, 0)
        target = -1
        expected = intArrayOf(1, 2)
        actual = sol.twoSum(import, target)
        assert(expected.contentEquals(actual))
    }
}
