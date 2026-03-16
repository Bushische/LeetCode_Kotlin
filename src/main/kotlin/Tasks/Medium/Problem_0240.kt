package leetcode.tasks.medium

class Problem_0240 {
    /* 240. Search a 2D Matrix II
    URL: https://leetcode.com/problems/search-a-2d-matrix-ii/description/

Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
    Integers in each row are sorted in ascending from left to right.
    Integers in each column are sorted in ascending from top to bottom.

Example 1:
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true

Example 2:
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false

Constraints:
m == matrix.length
n == matrix[i].length
1 <= n, m <= 300
-10^9 <= matrix[i][j] <= 10^9
All the integers in each row are sorted in ascending order.
All the integers in each column are sorted in ascending order.
-10^9 <= target <= 10^9
     */

    class Solution {
        /** IDEA: exclude rows:
         *  1. pass the row from left to right if the VALUE under index is less
         *  2. pass the row from right to left if the VALUE under index is larger
         *  3. If there is a switch of state and the VALUE is not TARGET, move to the next row
         *
         * keep in-row index between rows
         */
        fun searchMatrix(
            matrix: Array<IntArray>,
            target: Int,
        ): Boolean {
            var rows = matrix.size
            var cols = matrix[0].size

            var index = 0
            var rowIndex = 0 // first row
            var direction: Int // 1 - left to right, -1 - right to left
            var value: Int
            while (rowIndex < rows) {
                if (index < 0) index = 0
                if (index > cols - 1) index = cols - 1

                direction = if (matrix[rowIndex][index] < target) 1 else -1
                while ((index >= 0) && (index < cols)) {
                    value = matrix[rowIndex][index]
                    if (value == target) {
                        return true
                    } else if ((direction == 1) && (value > target)) {
                        break
                    } else if ((direction == -1) && (value < target)) {
                        break
                    }
                    index += direction
                }
                rowIndex++
            }
            return false
        }
    }
}
