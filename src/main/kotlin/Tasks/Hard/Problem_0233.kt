package leetcode.tasks.hard

class Problem_0233 {
    /* 233. Number of Digit One
    URL: https://leetcode.com/problems/number-of-digit-one/description/

Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

Example 1:
Input: n = 13
Output: 6

Example 2:
Input: n = 0
Output: 0

Constraints:
0 <= n <= 10^9
     */

    class Solution {
        fun countDigitOne(n: Int): Int {
            // brute force
            var count = 0
            val regex = Regex("[^1]", RegexOption.IGNORE_CASE)
            for (elem in 1..n) {
                val str = elem.toString()
                val clear = regex.replace(str, "")
                count += clear.length
            }
            return count
        }
    }
}

/** Hypothesis
 *
 // calculate by layers: ones, tens, hundreds....., Up to 9 layers

n = 130
ones: 1
13 times (1, 11, 21, ..., 91, 101, 111, 121)
13 = (130-1)/10+1
total = 13

tens: 10
2 times (10 and 110)
2 = (130-10)/100+1
but every tens is 10 entrance
but 11 is already calculated in ones, but only as 1, so still 10 entrance
total = 20 + 13 = 33

hundreds: 100
1 times (100)
1 = (130-100)/1000+1
but every hundreds is 100 entrance, except the last one
in the last hundreds = we have 130 % 100 + 1 = 31 entrances
total = 31 + 33 = 64

Answer = 63 ones in total
 *

n = 99
ones:
(99-1)/10+1 = 9+1=10
tens:
(99-1)/100+1 = 1*10=10
total = 20
 */
