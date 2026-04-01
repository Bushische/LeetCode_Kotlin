package leetcode.tasks.easy

class Problem_0263 {
    /* 263. Ugly Number
    URL: https://leetcode.com/problems/ugly-number/description/

An ugly number is a positive integer which does not have a prime factor other than 2, 3, and 5.
Given an integer n, return true if n is an ugly number.

Example 1:
Input: n = 6
Output: true
Explanation: 6 = 2 × 3

Example 2:
Input: n = 1
Output: true
Explanation: 1 has no prime factors.

Example 3:
Input: n = 14
Output: false
Explanation: 14 is not ugly since it includes the prime factor 7.

Constraints:
-2^31 <= n <= 2^31 - 1

     */

    class Solution {
        /** IDEA: brute force:
         *      - devide to 2, 3, 5 while mod (rest) of the division is 0
         *      - the input is an ugly number if we get 1 in the end
         */
        fun isUgly(n: Int): Boolean {
            var rest = n
            var prevRest = rest xor 1
            while ((rest > 1) && (rest != prevRest)) {
                prevRest = rest
                val mod2 = rest % 2
                if (mod2 == 0) {
                    rest = rest / 2
                }
                val mod3 = rest % 3
                if (mod3 == 0) {
                    rest = rest / 3
                }
                val mod5 = rest % 5
                if (mod5 == 0) {
                    rest = rest / 5
                }
            }
            return rest == 1
        }

        // from: https://leetcode.com/problems/ugly-number/solutions/7627251/kotlin-0ms-easy-solution-beats-100-by-ya-l1yx/
        fun isUgly_other_approach(a: Int): Boolean {
            var n = a
            if (n < 1) return false
            if (n == 1) return true
            while (n % 2 == 0) {
                n = n / 2
            }
            while (n % 3 == 0) {
                n = n / 3
            }
            while (n % 5 == 0) {
                n = n / 5
            }

            return n == 1
        }
    }
}
