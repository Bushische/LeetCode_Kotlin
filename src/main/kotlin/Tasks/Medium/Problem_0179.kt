package leetcode.tasks.medium

class Problem_0179 {
    /* 179. Largest Number
    URL: https://leetcode.com/problems/largest-number/description/

Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
Since the result may be very large, so you need to return a string instead of an integer.

Example 1:
Input: nums = [10,2]
Output: "210"

Example 2:
Input: nums = [3,30,34,5,9]
Output: "9534330"

Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 10^9
     */

    class Solution {
        /* unsuccessful IDEA: try to put on the next position the number with higher first digit
         if there is 9, it should be put to the first position.
         if we have 900, but there are 9 and 98, we should put 998 at the first position
         --
        take a maximum from the rest
        check, if we can construct a number bigger then max from the rest (the same length)
        => 987 and the rest 9,8,81 - 988 will be bigger than 987, (regardless what is after 7?) => even if 9881000000000987 > 9819881000000000

        solved after reading discussions only
         */
        fun largestNumber(nums: IntArray): String {
            val strNums = nums.map { it.toString() }
            // Custom comparator for descending order
            val descendingComparator =
                Comparator<String> { a, b ->
                    val ab = a + b
                    val ba = b + a
                    ab.compareTo(ba) * (-1)
                }
            var sortedNums = strNums.sortedWith(descendingComparator)

            // remove lead zeros
            val unprocessedResult = sortedNums.joinToString("")
            var zeros = 0
            while ((zeros < unprocessedResult.length) && (unprocessedResult[zeros] == '0')) {
                zeros++
            }
            if (zeros == unprocessedResult.length) zeros--
            var result = unprocessedResult.substring(zeros)
            return result
        }

        /* from discussion
this is too easy!
just sort by descending

strNums.sort((a, b) => (b + a).localeCompare(a + b)); // descending sort
---
The solution can't be correct without the transitivity:
If AB > BA and BC > CB, then we have AC > CA.
         */

        // Functional style
        //
        fun largestNumber_func_style(nums: IntArray): String =
            nums
                .map { it.toString() }
                .sortedWith(Comparator { a, b -> (b + a).compareTo(a + b) })
                .fold("") { acc, next -> acc + next }
                .takeIf { it[0] != '0' }
                ?: "0"
    }
}
