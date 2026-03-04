package leetcode.tasks.medium

import leetcode.models.TreeNode

class Problem_0236 {
    /* 236. Lowest Common Ancestor of a Binary Tree
    URL: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

Example 2:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

Example 3:
Input: root = [1,2], p = 1, q = 2
Output: 1

Constraints:
The number of nodes in the tree is in the range [2, 10^5].
-10^9 <= Node.val <= 10^9
All Node.val are unique.
p != q
p and q will exist in the tree.
     */

    class Solution {
        /** IDEA:
         * 1. The tree is not search tree, so any node can be at any place, so we need an algorith to find a path to node
         * 2. Find a path to the first node, return a full path
         * 3. Find a path to the second node, return a full path
         * 4. Passing through these path in parallel, till the last common node
         *
         */
        fun lowestCommonAncestor(
            root: TreeNode?,
            p: TreeNode?,
            q: TreeNode?,
        ): TreeNode? {
            if ((p == null) || (q == null)) {
                return null
            }

            val pPath = findPath(root, p)
            val qPath = findPath(root, q)

            var index = 0
            while ((index < pPath.size) && (index < qPath.size)) {
                if (pPath.get(index).`val` != qPath.get(index).`val`) {
                    break
                }
                index++
            }
            // index should point to the next to target node
            index--
            if (index >= 0) {
                return pPath.get(index)
            }

            return null
        }

        /** Find a path from root to node, if the node is not under the root, return false */
        internal fun findPath(
            root: TreeNode?,
            node: TreeNode?,
        ): List<TreeNode> {
            if (root == null) {
                return emptyList()
            }
            if (root == node) {
                return listOf(root)
            }

            val leftNodePath = findPath(root.left, node)
            if (leftNodePath.isNotEmpty()) {
                return listOf(root) + leftNodePath
            }

            val rightNodePath = findPath(root.right, node)
            if (rightNodePath.isNotEmpty()) {
                return listOf(root) + rightNodePath
            }
            return emptyList()
        }

        // ---------
        // AMAZING DFS solution
        fun dfs_lowestCommonAncestor(
            root: TreeNode?,
            p: TreeNode?,
            q: TreeNode?,
        ): TreeNode? {
            if (root == null || p == root || q == root) return root

            val left = lowestCommonAncestor(root?.left, p, q)
            val right = lowestCommonAncestor(root?.right, p, q)

            if (left != null && right != null) {
                return root
            }

            return if (left == null) right else left
        }
    }
}
