package leetcode.tasks.medium

import leetcode.models.TreeNode
import leetcode.tasks.medium.Problem_0173.BSTIterator
import kotlin.test.Test
import kotlin.test.assertEquals

class Problem_0173Test {
    @Test
    fun example1() {
        val inputTreeList = listOf<Int?>(7, 3, 15, null, null, 9, 20)
        val root = TreeNode.fromArray(inputTreeList)

        val bst = BSTIterator(root)
        assertEquals(3, bst.next())
        assertEquals(7, bst.next())
        assertEquals(true, bst.hasNext())
        assertEquals(9, bst.next())
        assertEquals(true, bst.hasNext())
        assertEquals(15, bst.next())
        assertEquals(true, bst.hasNext())
        assertEquals(20, bst.next())
        assertEquals(false, bst.hasNext())
    }
}
