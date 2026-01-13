package leetcode.tasks.easy

import leetcode.models.TreeNode

class Problem_0110 {
    /* 110. Balanced Binary Tree
    URL: https://leetcode.com/problems/balanced-binary-tree/

Given a binary tree, determine if it is height-balanced.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: true

Example 2:
Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Example 3:
Input: root = []
Output: true

Constraints:
The number of nodes in the tree is in the range [0, 5000].
-10^4 <= Node.val <= 10^4
     */

    class Solution {
        /* IDEA: the tree is balanced, if both its subtrees are also balanced
         * and their Depth differ by no more than 1
         */
        fun isBalanced(root: TreeNode?): Boolean {
            val rootDepth = getDepthAndBalanced(root)
            return rootDepth != null
        }

        /**
         * Calculate the Depth of the tree and return it if the tree is balanced
         * Or return NULL if the tree is not balanced
         *
         * Alternative: return "-1" instead of NULL
         */
        private fun getDepthAndBalanced(root: TreeNode?): Int? {
            if (root == null) {
                return 0
            }
            val leftDepth = getDepthAndBalanced(root.left)
            val rightDepth = getDepthAndBalanced(root.right)
            if ((leftDepth == null) || (rightDepth == null)) {
                return null
            }
            if (Math.abs(leftDepth - rightDepth) <= 1) {
                return 1 + Math.max(leftDepth, rightDepth)
            } else {
                return null
            }
        }
    }
}
