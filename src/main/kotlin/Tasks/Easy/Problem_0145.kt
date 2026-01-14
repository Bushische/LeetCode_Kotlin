package leetcode.tasks.easy

import leetcode.models.TreeNode

class Problem_0145 {
    /* 145. Binary Tree Postorder Traversal
    URL: https://leetcode.com/problems/binary-tree-postorder-traversal/description/

Given the root of a binary tree, return the postorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [3,2,1]
Explanation:

Example 2:
Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
Output: [4,6,7,5,2,9,8,3,1]
Explanation:

Example 3:
Input: root = []
Output: []

Example 4:
Input: root = [1]
Output: [1]

Constraints:
The number of the nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
     */

    class Solution {
        /* IDEA: use mutable list to collect all nodes' values into required output list
         */
        fun postorderTraversal(root: TreeNode?): List<Int> {
            val bufferList = mutableListOf<Int>()
            val outList = postorderWithOut(root, bufferList)
            return outList.toList()
        }

        private fun postorderWithOut(
            root: TreeNode?,
            list: MutableList<Int>,
        ): MutableList<Int> {
            if (root == null) {
                return list
            }
            postorderWithOut(root.left, list)
            postorderWithOut(root.right, list)
            list.add(root.`val`)
            return list
        }
    }
}
