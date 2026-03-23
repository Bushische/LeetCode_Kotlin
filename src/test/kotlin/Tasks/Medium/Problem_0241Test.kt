package leetcode.tasks.medium

import kotlin.test.Test
import kotlin.test.assertTrue

class Problem_0241Test {
    @Test
    fun example1() {
        val sol = Problem_0241.Solution()
        val input = "2-1-1"
        val expected = listOf(0, 2)

        val actual = sol.diffWaysToCompute(input)
        assertTrue(actual.containsAll(expected))
    }

    @Test
    fun example2() {
        val sol = Problem_0241.Solution()
        val input = "2*3-4*5"
        val expected = listOf(-14, -10, -10, 10, -34)

        val actual = sol.diffWaysToCompute(input)
        assertTrue(actual.containsAll(expected), "$expected <> $actual")
    }

    @Test
    fun example1mine() {
        val sol = Problem_0241.SolutionMyWrong()
        val input = "2-1-1"
        val expected = listOf(0, 2)

        val actual = sol.diffWaysToCompute(input)
        assertTrue(actual.containsAll(expected))
    }

    @Test
    fun example2mine() {
        val sol = Problem_0241.SolutionMyWrong()
        val input = "2*3-4*5"
        val expected = listOf(-14, -10, -10, 10, -34)

        val actual = sol.diffWaysToCompute(input)
        assertTrue(actual.containsAll(expected), "$expected <> $actual")
    }
}
