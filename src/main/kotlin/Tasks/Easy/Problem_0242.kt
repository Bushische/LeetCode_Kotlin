package leetcode.tasks.easy

import kotlin.collections.component2
import kotlin.collections.getValue

class Problem_0242 {
    /* 242. Valid Anagram
    URL: https://leetcode.com/problems/valid-anagram/description/

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

Constraints:
1 <= s.length, t.length <= 5 * 10^4
s and t consist of lowercase English letters.

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
     */

    class Solution {
        /** IDEA: collect array of pairs (char, number). if the sets of these pairs are the same, s and t are anagrams.
         */
        fun isAnagram(
            s: String,
            t: String,
        ): Boolean {
            if (s.length != t.length) return false

            val sSet = s.groupBy { it }.mapValues { (_, value) -> value.size }
            val tSet = t.groupBy { it }.mapValues { (_, value) -> value.size }

            return (sSet.size == tSet.size) && (sSet.all { (key, value) -> tSet.containsKey(key) && tSet.getValue(key) == value })
        }
    }

    // nice idea (but not implementation as this doesn't match unicode req)
    fun isAnagram_with_counter(
        s: String,
        t: String,
    ): Boolean {
        if (s.length != t.length) return false
        val arr = IntArray(128)
        for (char in s) {
            arr[char.code]++
        }
        for (char in t) {
            if (--arr[char.code] < 0) return false
        }
        return true
    }
}
