package leetcode.tasks.easy

import leetcode.models.TreeNode
import kotlin.test.*
import kotlin.test.Test

class Problem_0108Test {
    @Test
    fun examples() {
        val sol = Problem_0108.Solution()

        var input = intArrayOf(-10, -3, 0, 5, 9)
        var outputNums = listOf<Int?>(0, -3, 9, -10, null, 5)
        var actual = sol.sortedArrayToBST(input)
        var expected = TreeNode.fromArray(outputNums)
        assert(TreeNode.equals(expected, actual))

        input = intArrayOf(1, 3)
        outputNums = listOf<Int?>(3, 1)
        actual = sol.sortedArrayToBST(input)
        expected = TreeNode.fromArray(outputNums)
        assert(TreeNode.equals(expected, actual))
    }
}
