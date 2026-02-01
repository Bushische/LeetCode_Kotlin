package leetcode.tasks.medium

class Problem_0215 {
    /* 215. Kth Largest Element in an Array
    URL: https://leetcode.com/problems/kth-largest-element-in-an-array/description/

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

Constraints:
1 <= k <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
     */

    class Solution {
        /*  IDEA: have a Map of last n last max elements to they count
         */
        fun findKthLargest(
            nums: IntArray,
            k: Int,
        ): Int {
            val map = mutableMapOf<Int, Int>()

            var mapCnt = 0 // count of element in map
            var min = Int.MAX_VALUE
            for (index in 0 until nums.size) {
                val elem = nums[index]
                // need to keep in map only k elements
                if (mapCnt < k) {
                    map[elem] = map.getOrDefault(elem, 0) + 1
                    mapCnt++
                    min = Math.min(min, elem)
                } else if (elem > min) {
                    map[elem] = map.getOrDefault(elem, 0) + 1
                    val minCnt = map.getOrDefault(min, 1) - 1
                    if (minCnt == 0) {
                        map.remove(min)
                        min = map.keys.min()
                    } else {
                        map[min] = minCnt
                    }
                }
                // println("elem: $elem mapCnt: $mapCnt (${map.values.sum()}) min: $min map: $map")
            }

            // search for min
            return map.keys.min()
        }

        /* IDEA: pass through the input array and keep a track of last K largest elements
         * In the end select min from the array of last K largest elements
         */
        /* This version doesn't work due to time limit on big array
         */
        fun findKthLargest_wrong(
            nums: IntArray,
            k: Int,
        ): Int {
            // edge case to pass the test 44/45
            if (nums.size == k) {
                return nums.min()
            }

            val kBuffer = mutableListOf<Int>()
            var min = Int.MIN_VALUE

            for (index in 0 until nums.size) {
                val elem = nums[index]
                if ((elem > min) || (kBuffer.size < k)) {
                    // should be inserted
                    if (kBuffer.size == k) {
                        // need to remove the min element
                        kBuffer.remove(min)
                    }
                    kBuffer.add(elem)
                    min = kBuffer.min()
                    // println("min: $min elem: $elem, kBuffer: $kBuffer")
                }
            }

            val result = kBuffer.min()

            return result
        }
    }
}
