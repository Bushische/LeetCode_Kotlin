// package letcode

import leetcode.models.TreeNode
import leetcode.tasks.easy.*

fun main() {
    println("Hello Busya")
    // val row = Problem_0119.Solution().getRow(33)
    // println(row)

    val sol = Problem_0108.Solution()
    // val tree = sol.sortedArrayToBST(intArrayOf(-10, -3, 0, 5, 9))
    val tree = sol.sortedArrayToBST(intArrayOf(1, 3))
    TreeNode.printTreeNode(tree)
}
