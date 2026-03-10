package leetcode.tasks.medium

class Problem_0238 {
    /* 238. Product of Array Except Self
    URL: https://leetcode.com/problems/product-of-array-except-self/description/

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

Constraints:
2 <= nums.length <= 10^5
-30 <= nums[i] <= 30
The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
     */

    class Solution {
        /** IDEA: to calculate the product of array except a[i] we need to know product for a[j]
         * P[i] = P[j] / a[i] * a[j]
         * P[i] = a[1] * a[2] * a[i-1] * a[i+1] * ... * a[n]
         *
         * So, we need to calculate one product and use it to calculate all others
         *
         * Edge case - element with 0 in array
         *           - all elements are 0
         * if there are more than 2 zeros, all output should be zeros
         * if there is only one zero, only one element will be non-zero
         */
        fun productExceptSelf(nums: IntArray): IntArray {
            fun log(message: String) {
                // println(message)
            }

            // helper to calculate product of array elements excluding one element
            fun getProductExcept(exIndex: Int): Int {
                var prod = 1
                for (ind in 0 until nums.size) {
                    if (ind != exIndex) {
                        prod *= nums[ind]
                    }
                    if (prod == 0) {
                        return 0
                    }
                }
                return prod
            }

            // helper to calculate product for a[i] based on product of a[j]
            fun getProduct1(
                product0: Int,
                index0: Int,
                index1: Int,
            ): Int {
                if (index0 == index1) {
                    return product0
                }
                var outProduct = product0 / nums[index1] * nums[index0]
                return outProduct
            }

            val output = IntArray(nums.size)

            // calculate the first non-zero product
            var product0 = 0
            var index0 = 0
            while ((product0 == 0) && (index0 < nums.size)) {
                product0 = getProductExcept(index0)
                index0++
            }
            if ((index0 == nums.size) && (product0 == 0)) {
                return output // all elements are zeros
            } else {
                index0--
            }
            log("Product0 = $product0 and Index0 = $index0 | Output = $output")

            // calculate output array
            for (index in 0 until nums.size) {
                val tempSum = getProduct1(product0, index0, index)
                log(">> index = $index => product = $tempSum")
                output[index] = tempSum
            }

            return output
        }
    }
}
