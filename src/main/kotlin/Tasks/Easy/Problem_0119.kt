package leetcode.tasks.easy

import kotlin.collections.mutableListOf

class Problem_0119 {
    /* 119. Pascal's Triangle II
    URL: https://leetcode.com/problems/pascals-triangle-ii/description/

    Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:
Input: rowIndex = 3
Output: [1,3,3,1]

Example 2:
Input: rowIndex = 0
Output: [1]

Example 3:
Input: rowIndex = 1
Output: [1,1]

Constraints:

0 <= rowIndex <= 33

Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?
     */
    class Solution {
        fun getRow(rowIndex: Int): List<Int> {
            val buffer = mutableListOf<Int>()

            for (row in 0..rowIndex) {
                for (elem in 1 until row) {
                    val acc = getByIndex(buffer, elem - 1) + getByIndex(buffer, elem)
                    buffer[elem - 1] = acc
                }
                buffer.add(0, 1)
            }

            return buffer
        }

        private fun getByIndex(
            buffer: List<Int>,
            index: Int,
        ): Int {
            if (index >= buffer.count()) {
                return 0
            }
            return buffer[index]
        }
    }
}

/*
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1
1 5 10 10 5 1
1 6 15 20 15 6 1
1 7 21 35 35 21 7 1
1 8 28 56 70 56 28 8 1
*/
