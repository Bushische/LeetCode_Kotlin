package leetcode.tasks.easy

import leetcode.models.TreeNode
import kotlin.test.Test
import kotlin.test.assertEquals

class Problem_0145Test {
    @Test
    fun examples() {
        val sol = Problem_0145.Solution()

        // case 1
        var inputNums = listOf<Int?>(1, null, 2, 3)
        var expected = listOf<Int>(3, 2, 1)
        var inputTree = TreeNode.fromArray(inputNums)
        var actual = sol.postorderTraversal(inputTree)
        assertEquals(expected, actual)

        // case 2
        inputNums = listOf<Int?>(1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9)
        expected = listOf<Int>(4, 6, 7, 5, 2, 9, 8, 3, 1)
        inputTree = TreeNode.fromArray(inputNums)
        actual = sol.postorderTraversal(inputTree)
        assertEquals(expected, actual)

        // case 3
        inputNums = listOf<Int?>(1)
        expected = listOf<Int>(1)
        inputTree = TreeNode.fromArray(inputNums)
        actual = sol.postorderTraversal(inputTree)
        assertEquals(expected, actual)

        // case 4
        inputNums = listOf<Int?>()
        expected = listOf<Int>()
        inputTree = TreeNode.fromArray(inputNums)
        actual = sol.postorderTraversal(inputTree)
        assertEquals(expected, actual)
    }
}
