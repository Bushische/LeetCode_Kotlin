package leetcode.tasks.medium

import kotlin.collections.*
import kotlin.intArrayOf

class Problem_0221 {
    /* 221. Maximal Square
    URL: https://leetcode.com/problems/maximal-square/description/

Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example 1:
10100
10111
11111
10010

Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4

Example 2:
Input: matrix = [["0","1"],["1","0"]]
Output: 1

Example 3:
Input: matrix = [["0"]]
Output: 0

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 300
matrix[i][j] is '0' or '1'.
     */

    class Solution {
        /* IDEA: for the matrix calculate the longest sequence of 1 in the row finishing at this point
Example:
    10100 -> 10100
    10111 -> 10123
    11111 -> 12345
    10010 -> 10010
pass through the matrix, searching for the biggest square:
        1. if a[i,j] = n
        2. check n lines bellow
        3. if for all n lines below the a[x,j] >= n,
        4. we found the square with edge length n
Find the biggest n and calculate square = n*n
         */
        fun maximalSquare(matrix: Array<CharArray>): Int {
            val m = matrix.size
            val n = matrix[0].size

            // fill the matrix of longest sequence in the row
            var matrixOfSequences = Array<IntArray>(m) { IntArray(n) }
            for (i in 0 until m) {
                for (j in 0 until n) {
                    val el = matrix[i][j]
                    if (el == '0') {
                        matrixOfSequences[i][j] = 0
                    } else {
                        if (j == 0) {
                            matrixOfSequences[i][j] = 1
                        } else {
                            matrixOfSequences[i][j] = 1 + matrixOfSequences[i][j - 1]
                        }
                    }
                }
            }
            // println("original matrix: $matrix")
            // println("sequences matrix")
            // printMatrix(matrixOfSequences)

            // check the array of sequences by the rule
            // utility function
            fun getElement(
                i: Int,
                j: Int,
            ): Int {
                if (i >= m) {
                    return 0
                }
                if (j >= n) {
                    return 0
                }
                return matrixOfSequences[i][j]
            }
            var maxEdge = 0
            for (i in 0 until m) {
                for (j in 0 until n) {
                    if (matrixOfSequences[i][j] > maxEdge) {
                        // need to check from testValue until down to maxEdge+1
                        for (testValue in matrixOfSequences[i][j] downTo maxEdge) {
                            if (testValue <= maxEdge) {
                                break // don't need to pass
                            }
                            // check several rows below
                            var foundSquare = true
                            for (shift in 1 until testValue) {
                                if (getElement(i + shift, j) < testValue) {
                                    foundSquare = false
                                    break
                                }
                            }
                            if (foundSquare) {
                                maxEdge = testValue
                            }
                        }
                    }
                }
            }

            return maxEdge * maxEdge
        }

        fun printMatrix(matrix: Array<IntArray>) {
            val m = matrix.size

            for (i in 0 until m) {
                println(matrix[i].joinToString(","))
            }
        }
    }
}
