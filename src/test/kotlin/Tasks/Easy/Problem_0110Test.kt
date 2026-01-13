package leetcode.tasks.easy

import leetcode.models.TreeNode
import kotlin.test.Test
import kotlin.test.assertEquals

class Problem_0110Test {
    @Test
    fun examples() {
        val sol = Problem_0110.Solution()

        // case 1
        var inputNums = listOf<Int?>(3, 9, 20, null, null, 15, 7)
        var expected = true
        var treeRoot = TreeNode.fromArray(inputNums)
        var actual = sol.isBalanced(treeRoot)
        assertEquals(expected, actual)

        // case 2
        inputNums = listOf<Int?>(1, 2, 2, 3, 3, null, null, 4, 4)
        expected = false
        treeRoot = TreeNode.fromArray(inputNums)
        actual = sol.isBalanced(treeRoot)
        assertEquals(expected, actual)
    }
}
