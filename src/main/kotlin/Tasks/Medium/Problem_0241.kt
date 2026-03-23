package leetcode.tasks.medium

class Problem_0241 {
    /* 241. Different Ways to Add Parentheses
    URL: https://leetcode.com/problems/different-ways-to-add-parentheses/description/

Given a string expression of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. You may return the answer in any order.
The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed 104.

Example 1:
Input: expression = "2-1-1"
Output: [0,2]
Explanation:
((2-1)-1) = 0
(2-(1-1)) = 2

Example 2:
Input: expression = "2*3-4*5"

Explanation:
(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10

Constraints:
1 <= expression.length <= 20
expression consists of digits and the operator '+', '-', and '*'.
All the integer values in the input expression are in the range [0, 99].
The integer values in the input expression do not have a leading '-' or '+' denoting the sign.
     */

    class Solution {
        // Memoization map to store results of sub-expressions
        private val memo = HashMap<String, List<Int>>()

        fun diffWaysToCompute(expression: String): List<Int> {
            // Return cached result if already calculated
            if (memo.containsKey(expression)) {
                return memo[expression]!!
            }

            val result = mutableListOf<Int>()

            for (i in expression.indices) {
                val char = expression[i]

                // If current character is an operator, split the expression
                if (char == '+' || char == '-' || char == '*') {
                    // Divide: Recursively solve left and right parts
                    val leftResults = diffWaysToCompute(expression.substring(0, i))
                    val rightResults = diffWaysToCompute(expression.substring(i + 1))

                    // Conquer & Combine: Perform operation on all pairs of results
                    for (l in leftResults) {
                        for (r in rightResults) {
                            result.add(applyOperation(char, l, r))
                        }
                    }
                }
            }

            // Base Case: If no operators found, the expression is just a single number
            if (result.isEmpty()) {
                result.add(expression.toInt())
            }

            // Cache and return the final list of results for this sub-expression
            memo[expression] = result
            return result
        }

        // apply operation
        private fun applyOperation(
            operation: Char,
            arg1: Int,
            arg2: Int,
        ): Int =
            when (operation) {
                '+' -> arg1 + arg2
                '-' -> arg1 - arg2
                '*' -> arg1 * arg2
                else -> 0
            }
    }

    class SolutionMyWrong {
        // My unfinished solution (but with the same approach), modified following to the
        //  Simple Catalan number Kotlin solution
        // https://leetcode.com/problems/different-ways-to-add-parentheses/solutions/5808942/simple-catalan-number-kotlin-solution-by-tzw0/

        /** IDEA: at every number we have two option:
         *  1. apply operation (in front of the number) to the expression to the left and the number
         *      and process the left with a result of this operation
         *  2. apply operation to the expression to the left and the result of the number and the rest of combination
         *
         * 1+2+3+4
         * test 1: 1
         * test 2: 1+2 or 1 + (2...)
         * test 3: 3+3 or 3 + (3...) or 1+(2+3) or 1+(2+(3...))
         *
         * in total there will be 2^(n-1) where n - the number of numbers
         */
        fun diffWaysToCompute(expression: String): List<Int> {
            val (numbers, operations) = parseTheExpression(expression)

            fun Char.invoke(
                a: Int,
                b: Int,
            ) = when (this) {
                '+' -> a + b
                '-' -> a - b
                '*' -> a * b
                else -> throw UnsupportedOperationException()
            }

            val cache = HashMap<Pair<Int, Int>, List<Int>>()

            fun backtrack(
                left: Int = 0,
                right: Int = numbers.lastIndex,
            ): List<Int> {
                if (left == right) return listOf(numbers[left])
                val key = left to right
                return cache[key] ?: mutableListOf<Int>().also { result ->
                    for (i in left..<right) {
                        for (fromLeft in backtrack(left, i)) {
                            for (fromRight in backtrack(i + 1, right)) {
                                result += applyOperation(operations[i], fromLeft, fromRight)
                            }
                        }
                    }
                    cache[key] = result
                }
            }

            return backtrack()
        }

        // Parse the string to lists of numbers and operations in front of them
        // return two list of the same size
        private fun parseTheExpression(expression: String): Pair<List<Int>, List<String>> {
            val numbersAsString = expression.split("-", "+", "*")
            val operationsAsString = expression.split(Regex("\\d+")) // one or more digits

            val numbers = numbersAsString.map { it.toInt() }
            val operations = operationsAsString.filter { !it.isNullOrEmpty() }

            log("numbers(${numbers.size})={$numbers} operations(${operations.size})={$operations}")

            return Pair(numbers, operations)
        }

        // apply operation
        private fun applyOperation(
            operation: String,
            arg1: Int,
            arg2: Int,
        ): Int =
            when (operation) {
                "+" -> arg1 + arg2
                "-" -> arg1 - arg2
                "*" -> arg1 * arg2
                else -> 0
            }

        private fun log(message: String) {
            if (true) {
                println(message)
            }
        }
    }
}
