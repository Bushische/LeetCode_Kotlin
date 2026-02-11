package leetcode.tasks.medium

class Problem_0229 {
    /* 229. Majority Element II
    URL: https://leetcode.com/problems/majority-element-ii/description/

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Example 1:
Input: nums = [3,2,3]
Output: [3]

Example 2:
Input: nums = [1]
Output: [1]

Example 3:
Input: nums = [1,2]
Output: [1,2]

Constraints:
1 <= nums.length <= 5 * 10^4
-10^9 <= nums[i] <= 10^9

Follow up: Could you solve the problem in linear time and in O(1) space?
     */
    class Solution {
        /* IDEA: use voting algorithm: Boyer-Moore Voting Algorithm
         * keep two candidates and their count
         * if element is any of candidate, increase the candidate's counter
         * if element is not any of candidate, reduce both counters
         * if any of counter is 0, assign a candidate
         *
         * after find high appeared candidates, calculate the real number of appearance and select ones with n/2
         */
        fun majorityElement(nums: IntArray): List<Int> {
            var candidate1: Int? = null
            var candidate2: Int? = null
            var counter1: Int = 0
            var counter2: Int = 0

            // search for two most often appear candidate
            for (elem in nums) {
                when { // order of operations is important
                    elem == candidate1 -> {
                        counter1++
                    }

                    elem == candidate2 -> {
                        counter2++
                    }

                    counter1 == 0 -> {
                        candidate1 = elem
                        counter1 = 1
                    }

                    counter2 == 0 -> {
                        candidate2 = elem
                        counter2 = 1
                    }

                    (elem != candidate1) && (elem != candidate2) && (counter1 > 0) && (counter2 > 0) -> {
                        counter1--
                        counter2--
                    }
                }
            }

            println("1 >> can1=$candidate1 cnt1=$counter1 can2=$candidate2 cnt2=$counter2")

            // calculate real number of appearance
            counter1 = 0
            counter2 = 0
            for (elem in nums) {
                when {
                    elem == candidate1 -> counter1++
                    elem == candidate2 -> counter2++
                }
            }

            println("2 >> can1=$candidate1 cnt1=$counter1 can2=$candidate2 cnt2=$counter2")

            var outList = mutableListOf<Int>()
            var threshold = nums.size / 3

            if (counter1 > threshold) {
                outList.add(candidate1!!)
            }
            if (counter2 > threshold) {
                outList.add(candidate2!!)
            }

            return outList
        }
    }
}
