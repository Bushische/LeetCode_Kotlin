package leetcode.tasks.medium

import leetcode.models.TreeNode

class Problem_0230 {
    /* 230. Kth Smallest Element in a BST
    URL: https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3

Constraints:
The number of nodes in the tree is n.
1 <= k <= n <= 10^4
0 <= Node.val <= 10^4


Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?

     */

    class Solution {
        /* IDEA: when we have a tree, we can go to the smallest element (far left) and start passing LNR with reducing k
        as soon as we meet k=0 we should return the value as a result of the search

        We can do it recursively or iterative
         * recursion: how to return the value? return tupple of values (k, value)?
                - return negativeValue as found result. If the function call possitive - go next node
         * iterative: use stack and just return a value when k == 0

         */
        fun kthSmallest(
            root: TreeNode?,
            k: Int,
        ): Int {
            if (root == null) {
                return -1
            }
            return iterativeLNR(root, k)
        }

        private fun iterativeLNR(
            root: TreeNode,
            kk: Int,
        ): Int {
            val stack = mutableListOf<TreeNode>()
            var remain = kk

            // separated filling to avoid cycle
            fun fillLeft(node: TreeNode): TreeNode {
                var n = node
                while (n.left != null) {
                    stack.add(0, n)
                    n = n.left!!
                }
                return n
            }

            var node = root
            // fill left branch to stack and go deep left. Without changes `remain`
            node = fillLeft(node)
            while (node != null) {
                // println("while: node=${node.`val`} remain=$remain stack=${stack.joinToString(","){it.`val`.toString()}}")
                if (remain == 1) {
                    return node.`val`
                }
                remain--
                if (node.right != null) {
                    node = node.right!!
                    // fill left and go deep left
                    node = fillLeft(node)
                } else {
                    node = stack.removeAt(0)
                }
            }
            return -1 // error
        }
    }
}

/* Nice solution from: https://leetcode.com/problems/kth-smallest-element-in-a-bst/solutions/4279655/kotlin-solution-by-nothingelsematters-gu2z/

class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int = search(root, k).second!!

    private fun search(v: TreeNode?, k: Int, previous: Int = 0): Pair<Int, Int?> {
        val node = v ?: return previous to null
        val (leftSize, leftAnswer) = search(node.left, k, previous)

        return when {
            leftAnswer != null -> leftSize + 1 to leftAnswer
            leftSize + 1 == k -> leftSize + 1 to node.`val`
            else -> search(node.right, k, leftSize + 1)
        }
    }
}


 */
