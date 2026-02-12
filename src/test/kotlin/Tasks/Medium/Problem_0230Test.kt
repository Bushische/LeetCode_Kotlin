package leetcode.tasks.medium

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import leetcode.models.TreeNode

class Problem_0230Test {
    @Test
    fun example1() {
        val sol = Problem_0230.Solution()
        val input = listOf<Int?>(3,1,4,null,2)
        val k = 1
        val expected = 1
        val root = TreeNode.fromArray(input)
        val actual = sol.kthSmallest(root, k)
        assertEquals(expected, actual)
    }

    @Test
    fun example2() {
        val sol = Problem_0230.Solution()
        val input = listOf<Int?>(5,3,6,2,4,null,null,1)
        val k = 3
        val expected = 3
        val root = TreeNode.fromArray(input)
        val actual = sol.kthSmallest(root, k)
        assertEquals(expected, actual)
    }

    @Test
    fun example1mine() {
        val sol = Problem_0230.Solution()
        val input = listOf<Int?>(5,3,6,2,4,null,null,1)
        val k = 4
        val expected = 4
        val root = TreeNode.fromArray(input)
        val actual = sol.kthSmallest(root, k)
        assertEquals(expected, actual)
    }

    @Test
    fun example2mine() {
        val sol = Problem_0230.Solution()
        val input = listOf<Int?>(5,3,6,2,4,null,null,1)
        val k = 5
        val expected = 5
        val root = TreeNode.fromArray(input)
        val actual = sol.kthSmallest(root, k)
        assertEquals(expected, actual)
    }

    @Test
    fun example3mine() {
        val sol = Problem_0230.Solution()
        val input = listOf<Int?>(5,3,6,2,4,null,null,1)
        val k = 6
        val expected = 6
        val root = TreeNode.fromArray(input)
        val actual = sol.kthSmallest(root, k)
        assertEquals(expected, actual)
    }
}