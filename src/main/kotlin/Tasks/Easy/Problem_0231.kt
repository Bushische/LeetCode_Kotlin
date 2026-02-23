package leetcode.tasks.easy

class Problem_0231 {
    /* 231. Power of Two
    URL: https://leetcode.com/problems/power-of-two/description/

Given an integer n, return true if it is a power of two. Otherwise, return false.

An integer n is a power of two, if there exists an integer x such that n == 2x.

Example 1:
Input: n = 1
Output: true
Explanation: 2^0 = 1

Example 2:
Input: n = 16
Output: true
Explanation: 2^4 = 16

Example 3:
Input: n = 3
Output: false

Constraints:
-2^31 <= n <= 2^31 - 1

Follow up: Could you solve it without loops/recursion?
     */

    class Solution {
        /* IDEA: just calculate number of 1
         */
        fun isPowerOfTwo(n: Int): Boolean {
            var pattern = 0b1
            var countOfOne = 0

            while ((pattern <= n) && (pattern > 0)) {
                // println("pattern=$pattern count=$countOfOne")
                val andResult = pattern and n
                if (andResult > 0) {
                    countOfOne++
                }
                pattern = pattern shl 1
            }
            return countOfOne == 1
        }
    }

    // Complexity:
    // Time O(1) and Space O(1).
    // from: https://leetcode.com/problems/power-of-two/solutions/7059349/my-kotlin-solution-with-time-o1-and-spac-i0wu/
    fun isPowerOfTwo_simpl(n: Int): Boolean = n > 0 && (n and (n - 1) == 0)
}
