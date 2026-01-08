package leetcode.tasks.easy

import leetcode.models.TreeNode

class Problem_0108 {
    /**     108. Convert Sorted Array to Binary Search Tree
     *  URL: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
     * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
     *
     * Example 1:
     * Input: nums = [-10,-3,0,5,9]
     * Output: [0,-3,9,-10,null,5]
     * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
     *
     * Example 2:
     * Input: nums = [1,3]
     * Output: [3,1]
     * Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
     *
     *
     * Constraints:
     * 1 <= nums.length <= 10^4
     * -10^4 <= nums[i] <= 10^4
     * nums is sorted in a strictly increasing order.
     */

    class Solution {
        /**
         * IDEA:
         * 1. take a middle element of the array and make it root of the tree
         * 2. Repeat operation for the left and right halfs
         *      set roots of corelated trees as left and right subtree of the root
         */
        fun sortedArrayToBST(nums: IntArray): TreeNode? = buildTree(nums)

        private fun buildTree(nums: IntArray): TreeNode? {
            if (nums.size == 0) return null
            val mid = nums.size / 2
            val midVal = nums[mid]
            val root = TreeNode(midVal)

            if (mid > 0) {
                val leftSubArray = nums.sliceArray(0..mid - 1)
                root.left = buildTree(leftSubArray)
            }
            if (mid < nums.size - 1) {
                val rightSubArray = nums.sliceArray(mid + 1..nums.size - 1)
                root.right = buildTree(rightSubArray)
            }

            return root
        }
    }
}
