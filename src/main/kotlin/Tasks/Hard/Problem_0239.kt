package leetcode.tasks.hard

import kotlin.math.max

class Problem_0239 {
    /* 239. Sliding Window Maximum
    URL: https://leetcode.com/problems/sliding-window-maximum/description/

You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
Return the max sliding window.

Example 1:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

 Example 2:
Input: nums = [1], k = 1
Output: [1]

Constraints:
1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
1 <= k <= nums.length
     */

    class Solution {
        /** IDEA: take a sliding window, calc max
         * on every step remove element from left and if it is not max, compare with a new element from right
         * if the left element (removed) is old max, find new max in window
         *
         */
        fun maxSlidingWindow(
            nums: IntArray,
            k: Int,
        ): IntArray {
            // helper to find max in array
            fun findMax(left: Int): Int {
                var max: Int = nums[left]
                var index = 1
                while (index < k) {
                    max = max(max, nums[left + index])
                    index++
                }
                return max
            }

            var left = 0
            var maxLeft = nums.size - k + 1
            var output = IntArray(maxLeft)
            var max: Int? = null
            while (left < maxLeft) {
                if (max == null) {
                    max = findMax(left)
                } else {
                    val vleft = nums[left - 1]
                    val vright = nums[left + k - 1]
                    // println("out: $vleft in: $vright max: $max") // -1,3,5
                    if (vright >= max!!) {
                        max = vright
                    } else if (vleft == max) {
                        max = findMax(left)
                    }
                }

                output[left] = max!!
                left++
            }

            return output
        }
    }
}

/** Nice solution: https://leetcode.com/problems/sliding-window-maximum/solutions/7090507/sliding-window-maximum-monotonic-queue-1-0t7a/

import java.util.ArrayDeque

class Solution {
 fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
 val dq = ArrayDeque<Int>()
 val res = mutableListOf<Int>()

 for (right in nums.indices) {
 while (dq.isNotEmpty() && nums[dq.last] < nums[right]) {
 dq.removeLast()
 }
 dq.addLast(right)

 if (dq.first <= right - k) {
 dq.removeFirst()
 }

 if (right >= k - 1) {
 res.add(nums[dq.first])
 }
 }

 return res.toIntArray()
 }
}*/
