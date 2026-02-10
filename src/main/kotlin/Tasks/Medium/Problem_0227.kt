package leetcode.tasks.medium

class Problem_0227 {
    /* 227. Basic Calculator II
    URL: https://leetcode.com/problems/basic-calculator-ii/description/

Given a string s which represents an expression, evaluate this expression and return its value.

The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of [-2^31, 2^31 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

Example 1:
Input: s = "3+2*2"
Output: 7

Example 2:
Input: s = " 3/2 "
Output: 1

Example 3:
Input: s = " 3+5 / 2 "
Output: 5

Constraints:
1 <= s.length <= 3 * 10^5
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 2^31 - 1].
The answer is guaranteed to fit in a 32-bit integer.
     */

    class Solution {
        /*  IDEA: we can use back Polish record, but we need to create a recursive function to parse the expression

        IDEA 2: split calculation in two steps:
            1. calculate high priority operation "*" and "/".
                Use a straigt order, so "5/2*4" should be calculated as "(5/2)*4 = 8", but not (5/(2*4) = 0)
            2. calculate low priority operation "+" and "-".
         */

        fun calculate(s: String): Int {
            var parts = splitStringExpression(s)
            // println("parsed: ${parts.joinToString(",")}")
            val squished = calculateHighPriorityOnly(parts)
            // println("squished: ${parts.joinToString(",")}")
            val result = calculateLowPriority(squished)
            return result
        }

        private fun calculateHighPriorityOnly(parts: List<String>): List<String> {
            // println("High priority: '${parts.joinToString(",")}'")
            val output = mutableListOf<String>()
            // val parts = s.split("+", "-", "*", "/")
            val lowPriority = setOf("-", "+")

            var buffer = 0
            var operation = "+"

            for (unclearPart in parts) {
                // println("H: buffer=$buffer operation=$operation part='$unclearPart'")
                val part = unclearPart.trim()
                var numValue = part.toIntOrNull()
                if (numValue == null) { // this is operation
                    operation = part // keep for the next calculation
                } else {
                    when {
                        lowPriority.contains(operation) -> {
                            output.add(buffer.toString())
                            output.add(operation)
                            buffer = numValue
                            operation = "+"
                        }

                        operation == "*" -> {
                            buffer = buffer * numValue
                        }

                        operation == "/" -> {
                            buffer = buffer / numValue
                        }
                    }
                }
            }
            output.add(buffer.toString())
            return output
        }

        private fun calculateLowPriority(parts: List<String>): Int {
            // println("Low priority: '${parts.joinToString()}'")

            var buffer = 0
            var operation = "+"

            for (part in parts) {
                // println("L: buffer=$buffer operation=$operation part='$part'")
                var numValue = part.toIntOrNull()
                if (numValue == null) { // this is operation
                    operation = part // keep for the next calculation
                } else {
                    buffer =
                        when (operation) {
                            "+" -> buffer + numValue
                            "-" -> buffer - numValue
                            else -> buffer
                        }
                }
            }
            return buffer
        }

        private fun splitStringExpression(s: String): List<String> {
            val output = mutableListOf<String>()
            var substr = s
            var nextOperationIndex = substr.indexOfAny(charArrayOf('+', '-', '*', '/'))
            while (nextOperationIndex > -1) {
                // println("S: substr='$substr' nOI=$nextOperationIndex")
                val nextDigit = substr.substring(0, nextOperationIndex)
                val nextOperation = substr.substring(nextOperationIndex, nextOperationIndex + 1)
                output.add(nextDigit.trim())
                output.add(nextOperation)
                substr = substr.substring(nextOperationIndex + 1)
                nextOperationIndex = substr.indexOfAny(charArrayOf('+', '-', '*', '/'))
            }
            output.add(substr.trim())
            return output
        }
    }
}


/** GOOD EXAMPLE
import java.util.*

class Solution {
    fun calculate(s: String): Int {
        val stack = Stack<Int>()
        var digit = 0
        var action = '+'
        for (i in 0..s.lastIndex) {
            val char = s[i]
            if (char.isDigit()) digit = digit * 10 + char.toInt() - '0'.toInt()

            if ((char.isDigit().not() && char.isWhitespace().not()) || i == s.lastIndex) {
                when (action) {
                    '+' -> stack.add(digit)
                    '-' -> stack.add(-digit)
                    '*' -> stack.add(stack.pop() * digit)
                    '/' -> stack.add(stack.pop() / digit)
                }
                action = char
                digit = 0
            }
        }
        return stack.sum()
    }
} 

 * 
 */