package leetcode.tasks.easy

import kotlin.test.Test
import kotlin.test.assertEquals
import leetcode.models.TreeNode

class Problem_0222Test {
    @Test
    fun example1() {
        val sol = Problem_0222.Solution()
        val importNums = listOf<Int?>(1,2,3,4,5,6)
        val expected = 6
        val root = TreeNode.fromArray(importNums)
        val actual = sol.countNodes(root)
        assertEquals(expected, actual)
    }

    @Test
    fun example2() {
        val sol = Problem_0222.Solution()
        val importNums = listOf<Int?>()
        val expected = 0
        val root = TreeNode.fromArray(importNums)
        val actual = sol.countNodes(root)
        assertEquals(expected, actual)
    }
    
    @Test
    fun example3() {
        val sol = Problem_0222.Solution()
        val importNums = listOf<Int?>(1)
        val expected = 1
        val root = TreeNode.fromArray(importNums)
        val actual = sol.countNodes(root)
        assertEquals(expected, actual)
    }
}