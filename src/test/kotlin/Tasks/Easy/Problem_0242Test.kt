package leetcode.tasks.easy

import kotlin.test.Test
import kotlin.test.assertEquals

class Problem_0242Test {
    @Test
    fun example1() {
        val sol = Problem_0242.Solution()
        val s = "anagram"
        val t = "nagaram"
        val expected = true
        val actual = sol.isAnagram(s, t)
        assertEquals(expected, actual)
    }

    @Test
    fun example2() {
        val sol = Problem_0242.Solution()
        val s = "rat"
        val t = "car"
        val expected = false
        val actual = sol.isAnagram(s, t)
        assertEquals(expected, actual)
    }

    // ------- mine
    @Test
    fun example1mine() {
        val sol = Problem_0242.Solution()
        val s = "rat"
        val t = ""
        val expected = false
        val actual = sol.isAnagram(s, t)
        assertEquals(expected, actual)
    }
}
