package leetcode.tasks.easy

import leetcode.models.TreeNode
import kotlin.test.Test
import kotlin.test.assertEquals

class Problem_0104Test {
    @Test
    fun examples() {
        val sol = Problem_0104.Solution()

        val input1 = listOf<Int?>(3)
        val input1TreeNode = TreeNode.fromArray(input1)
        assertEquals(1, sol.maxDepth(input1TreeNode))

        val input2 = listOf<Int?>(3, 9)
        val input2TreeNode = TreeNode.fromArray(input2)
        assertEquals(2, sol.maxDepth(input2TreeNode))

        val input3 = listOf<Int?>(3, 9, 20)
        val input3TreeNode = TreeNode.fromArray(input3)
        assertEquals(2, sol.maxDepth(input3TreeNode))

        val input4 = listOf<Int?>(3, 9, 20, null, 1)
        val input4TreeNode = TreeNode.fromArray(input4)
        assertEquals(3, sol.maxDepth(input4TreeNode))

        val input5 = listOf<Int?>(3, 9, 20, null, null, 15, 7)
        val input5TreeNode = TreeNode.fromArray(input5)
        assertEquals(3, sol.maxDepth(input5TreeNode))
    }
}
