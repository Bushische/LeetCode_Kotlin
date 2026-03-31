package leetcode.tasks.easy

class Problem_0258 {
    /* 258. Add Digits
    URL: https://leetcode.com/problems/add-digits/description/

Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

Example 1:
Input: num = 38
Output: 2
Explanation: The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2
Since 2 has only one digit, return it.

Example 2:
Input: num = 0
Output: 0

Constraints:
0 <= num <= 2^31 - 1

Follow up: Could you do it without any loop/recursion in O(1) runtime?
     */

    class Solution {
        /** IDEA: take the rest of division by 10 and sum, continue until the numbe is 1 digit */
        fun addDigits(num: Int): Int {
            var number = num
            while (number >= 10) {
                val rest = number % 10
                number = number / 10 + rest
            }
            return number
        }

        // from: https://leetcode.com/problems/add-digits/solutions/7054129/without-loops-and-recursive-by-vazovsky1-m2v0/
        fun addDigits_with_0_runtime(num: Int): Int = if (num == 0) 0 else 1 + (num - 1) % 9
    }
}

/*
54321 -> 5433 -> 546 -> 60 -> 6
*/
