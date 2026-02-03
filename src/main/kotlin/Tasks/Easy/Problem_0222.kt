package leetcode.tasks.easy

import leetcode.models.TreeNode

class Problem_0222 {
    /* 222. Count Complete Tree Nodes
    URL: https://leetcode.com/problems/count-complete-tree-nodes/

Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.

Example 1:
Input: root = [1,2,3,4,5,6]
Output: 6

Example 2:
Input: root = []
Output: 0

Example 3:
Input: root = [1]
Output: 1

Constraints:
The number of nodes in the tree is in the range [0, 5 * 10^4].
0 <= Node.val <= 5 * 10^4
The tree is guaranteed to be complete.
     */

    /**
     * Example:
     * var ti = TreeNode(5)
     * var v = ti.`val`
     * Definition for a binary tree node.
     * class TreeNode(var `val`: Int) {
     *     var left: TreeNode? = null
     *     var right: TreeNode? = null
     * }
     */
    class Solution {
        /* IDEA:
            Naive: we can follow the right side and find the level, where we don't have a next right node:
         * the last level could be the one we are on which or next
         * the problem, there could be only one node on the left side, so it's unclear how to calculate with O(n)

            Not naive: we can use stack to pass through the tree:
                1. put root to queue
                2. repeat in loop while the queue is not empty:
         * take node
         * add nested nodes to queue
         * increase the counter of nodes
            with this approach, every node will be visited only once, so we have O(n)
         */

        fun countNodes(root: TreeNode?): Int {
            val queue = mutableListOf<TreeNode?>(root)
            var nodeCount = 0
            var node = queue.removeAt(0)
            while (node != null) {
                nodeCount++
                if (node.left != null) {
                    queue.add(node.left)
                }
                if (node.right != null) {
                    queue.add(node.right)
                }
                node = if (queue.isEmpty()) null else queue.removeAt(0)
            }
            return nodeCount
        }
    }
}
