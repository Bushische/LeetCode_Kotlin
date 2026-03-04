package leetcode.tasks.medium

import leetcode.models.TreeNode
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class Problem_0236Test {
    @Test
    fun example1() {
        val sol = Problem_0236.Solution()
        val inputArray = listOf<Int?>(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)
        val inP = 5
        val inQ = 1
        val expected = 3
        val root = TreeNode.fromArray(inputArray)
        val pNode = TreeNode.findNode(root, inP)
        val qNode = TreeNode.findNode(root, inQ)
        val actualNode = sol.lowestCommonAncestor(root, pNode, qNode)
        assertNotNull(actualNode)
        assertEquals(expected, actualNode.`val`)
    }

    @Test
    fun example2() {
        val sol = Problem_0236.Solution()
        val inputArray = listOf<Int?>(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)
        val inP = 5
        val inQ = 4
        val expected = 5
        val root = TreeNode.fromArray(inputArray)
        val pNode = TreeNode.findNode(root, inP)
        val qNode = TreeNode.findNode(root, inQ)
        val actualNode = sol.lowestCommonAncestor(root, pNode, qNode)
        assertNotNull(actualNode)
        assertEquals(expected, actualNode.`val`)
    }

    @Test
    fun example3() {
        val sol = Problem_0236.Solution()
        val inputArray = listOf<Int?>(1, 2)
        val inP = 1
        val inQ = 2
        val expected = 1
        val root = TreeNode.fromArray(inputArray)
        val pNode = TreeNode.findNode(root, inP)
        val qNode = TreeNode.findNode(root, inQ)
        val actualNode = sol.lowestCommonAncestor(root, pNode, qNode)
        assertNotNull(actualNode)
        assertEquals(expected, actualNode.`val`)
    }
}
