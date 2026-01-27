package leetcode.tasks.easy

import kotlin.collections.Set

class Problem_0202 {
    /** 202. Happy Number
     URL: https://leetcode.com/problems/happy-number/

     Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

Example 1:
Input: n = 19
Output: true

Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

Example 2:
Input: n = 2
Output: false
Explanation:
2 -> 4 -> 16 -> 37 -> 9 + 49 = 58 -> 25 + 64 = 89 -> 64 + 81 = 145 -> 1 + 16 + 25 = 42 -> 16 + 4 = 20 -> 4 + 0 = 4 !

Constraints:

1 <= n <= 2^31 - 1
     */

    class Solution {
        fun isHappy(n: Int): Boolean {
            val setOfSums = mutableSetOf<Int>(n)
            var iteration = 0 // to stop the infinite loop
            val STOP_ITERATION = 10_000

            var currentValue = n
            while ((iteration < STOP_ITERATION) && (currentValue != 1)) {
                val newValue = calculateSumOfSquares(currentValue)
                // println("calculate: $currentValue -> $newValue")
                currentValue = newValue
                if (setOfSums.contains(currentValue)) {
                    return false // we already checked the value
                }
                setOfSums.add(currentValue)
                iteration++
            }

            // println("result: $currentValue")
            return currentValue == 1
        }

        private fun calculateSumOfSquares(n: Int): Int {
            var sum = 0

            var rest = n
            while (rest != 0) {
                val lastDigit = rest % 10
                rest = rest / 10
                sum += lastDigit * lastDigit
            }

            return sum
        }
    }
}
