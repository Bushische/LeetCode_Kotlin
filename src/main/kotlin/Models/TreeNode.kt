package leetcode.models

import kotlin.collections.mutableListOf

class TreeNode(
    var `val`: Int,
) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    companion object {
        /**
         * Convert the List<Int?> into TreeNode
         */
        fun fromArray(nums: List<Int?>): TreeNode? {
            if (nums.size == 0) {
                return null
            }

            // create root
            val elem = nums[0]
            if (elem == null) {
                return null
            }
            var root: TreeNode = TreeNode(elem)

            val buffer = mutableListOf<TreeNode>(root)

            // process the rest
            var index = 1
            while (index < nums.count()) {
                // take next node to assign branches
                val treeNode = buffer.get(0)
                buffer.removeAt(0)

                val left = getByIndexOrNull(nums, index)
                if (left != null) {
                    val leftNode = TreeNode(left)
                    buffer.add(leftNode)
                    treeNode.left = leftNode
                }
                index++

                val right = getByIndexOrNull(nums, index)
                if (right != null) {
                    val rightNode = TreeNode(right)
                    buffer.add(rightNode)
                    treeNode.right = rightNode
                }
                index++
            }

            return root
        }

        /**
         * Print the tree to console
         */
        fun printTreeNode(
            root: TreeNode?,
            indent: String = "",
        ) {
            if (root == null) {
                println("${indent}null")
                return
            }
            printTreeNode(root?.left, "$indent..")
            println("$indent${root?.`val`}")
            printTreeNode(root?.right, "$indent,,")
        }

        fun equals(
            root1: TreeNode?,
            root2: TreeNode?,
        ): Boolean {
            if ((root1 == null) && (root2 == null)) {
                return true
            }
            if ((root1 == null) || (root2 == null)) {
                return false
            }
            return (root1.`val` == root2.`val`) &&
                (equals(root1.left, root2.left)) &&
                (equals(root1.right, root2.right))
        }

        // utility to get safely
        private fun getByIndexOrNull(
            nums: List<Int?>,
            index: Int,
        ): Int? {
            if (index >= nums.size) return null
            return nums[index]
        }
    }
}
