package leetcode.tasks.medium

class Problem_0209 {
    /* 209. Minimum Size Subarray Sum
    URL: https://leetcode.com/problems/minimum-size-subarray-sum/description/

Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1

Example 3:
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0

Constraints:
1 <= target <= 10^9
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^4

Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
     */

    class Solution {
        /* IDEA: calculate array of sum 1-i
         * [1,2,3] -> [0,1,3,6]
         * using the sum array, using two pointers (left and right), find all combination [right-left >= target]
         * Register the minimum [right-left]
         */
        fun minSubArrayLen(
            target: Int,
            nums: IntArray,
        ): Int {
            // form array of sums
            var sumArray = Array<Int>(nums.size + 1) { 0 }
            sumArray[0] = 0
            sumArray[1] = nums[0]
            for (index in 1..nums.size) {
                sumArray[index] = nums[index - 1] + sumArray[index - 1]
            }

            // edge case, there is no required sub-aarray
            if (sumArray[sumArray.size - 1] < target) {
                return 0
            }

            // use two pointers     // [1,2,3] -> [0,1,3,6]
            var left = 0
            var right = 1
            var minLength = Int.MAX_VALUE
            while ((left < sumArray.size) && (right < sumArray.size)) {
                // calculate diff [right-left]
                val sum = sumArray[right] - sumArray[left]
                val length = right - left
                if ((sum >= target) && (length < minLength)) {
                    minLength = length
                }
                // micro optimization
                if (minLength == 1) {
                    return minLength
                }

                // move pointers
                if (sum >= target) { // move left
                    left++
                } else {
                    right++
                }
            }
            return minLength
        }
    }

    // just in two pointers:
    // URL: https://leetcode.com/problems/minimum-size-subarray-sum/solutions/7164793/aaaaaaaaaaaaaaaaaaaaaaaaaaa-by-danisdeve-q1bm/
    fun minSubArrayLen_2p(
        target: Int,
        nums: IntArray,
    ): Int {
        var current = 0
        var res = Int.MAX_VALUE
        var len = 0
        var left = 0
        for (i in nums.indices) {
            current += nums[i]
            len++
            while (current >= target) {
                res = minOf(res, len)
                current -= nums[left]
                left++
                len--
            }
        }
        return if (res == Int.MAX_VALUE) 0 else res
    }
}
