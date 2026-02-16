package leetcode.tasks.easy

class Problem_0228 {
    /* 228. Summary Ranges
    URL: https://leetcode.com/problems/summary-ranges/description/

You are given a sorted unique integer array nums.

A range [a,b] is the set of all integers from a to b (inclusive).

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b


Example 1:

Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
Example 2:

Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"


Constraints:

0 <= nums.length <= 20
-2^31 <= nums[i] <= 2^31 - 1
All the values of nums are unique.
nums is sorted in ascending order.
     */

    class Solution {
        /* IDEA: pass the array from left to right, and
            if the next element in the array is +1 to the previous, extend the interval
            if the next element > than +1 to the previous, close the interval and start new one
            Extra, if left and right boarders of the interval is the same number, output only one number
         */
        fun summaryRanges(nums: IntArray): List<String> {
            if (nums.size == 0) {
                return listOf<String>()
            }

            val outputList = mutableListOf<String>()

            fun addToList(
                left: Int,
                right: Int,
            ) {
                if (left == right) {
                    outputList.add(left.toString())
                } else {
                    outputList.add("$left->$right")
                }
            }

            var left: Int = nums[0]
            var right: Int = nums[0]
            var index = 1
            while (index < nums.size) {
                val elem = nums[index]
                if (elem > (right + 1)) {
                    addToList(left, right)
                    left = elem
                }
                right = elem
                index++
            }
            addToList(left, right)

            return outputList
        }
    }
}
