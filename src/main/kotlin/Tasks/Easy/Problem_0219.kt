package leetcode.tasks.easy

class Problem_0219 {
    /* 219. Contains Duplicate II
    URL: https://leetcode.com/problems/contains-duplicate-ii/

Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false

Constraints:
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
0 <= k <= 10^5
     */

    class Solution {
/** Basic idea: enumerate all elements i=0..n-k
         *              check all j=i..i+k
         *              if a[i] == a[j] true
         *
         * if after finish i didn't find i,j, return false
         *
         * Complexity O(n*k), need to pass up to n elements, for every i need make up to k operations. O <= 10^10
         *
         * ----
         *
         * Optimization:
         *  idea: find all non-unique elements in the array
         *  for every elements collect all indexes
         *  for every elements, using the collection of indexes, find a combination where i-j <= k
         *  if the combination is found, return true
         *      return false elsewhere
         *
         *  1. the first pass = to collect all indexes per number
         *  2. the second pass to remove all numbers with only 1 index
         *  3. the third pass to calculate all indexes
         *
         *  Complexity: O(3n)
         *  Memory: O(n)
         */
        fun containsNearbyDuplicate(
            nums: IntArray,
            k: Int,
        ): Boolean {
            val numbers = hashMapOf<Int, MutableList<Int>>()
            // collect all indexes
            for (i in 0..<nums.size) {
                val el = nums[i]
                val elArray = numbers.getOrDefault(el, mutableListOf<Int>())
                elArray.add(i)
                numbers[el] = elArray
            }
            // filter out all number with only one index
            val filteredNumbers = numbers.filter { (_, v) -> v.size > 1 } // {it.value.size > 1}
            // search for pair of indexes
            for (indexes in filteredNumbers.values) {
                val sortedIndexes = indexes.sorted()
                for (j in 1..<sortedIndexes.size) {
                    if ((sortedIndexes[j] - sortedIndexes[j - 1]) <= k) {
                        return true
                    }
                }
            }
            return false
        }
    }

    // from https://leetcode.com/problems/contains-duplicate-ii/solutions/1057965/kotlin-simple-by-georgcantor-xplz/
    fun containsNearbyDuplicate_simple(
        nums: IntArray,
        k: Int,
    ): Boolean {
        val map = HashMap<Int, Int>()
        nums.forEachIndexed { i, num ->
            if (map.containsKey(num) && i - map[num]!! <= k) return true
            map[num] = i
        }

        return false
    }
}
