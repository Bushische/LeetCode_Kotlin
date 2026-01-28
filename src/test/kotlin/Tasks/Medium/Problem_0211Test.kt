package leetcode.tasks.medium

import kotlin.test.Test
import kotlin.test.assertEquals

class Problem_0211Test {
    @Test
    fun example1() {
        val wordDictionary = Problem_0211.WordDictionary()
        wordDictionary.addWord("bad")
        wordDictionary.addWord("dad")
        wordDictionary.addWord("mad")
        assertEquals(false, wordDictionary.search("pad")) // return False
        assertEquals(true, wordDictionary.search("bad")) // return True
        assertEquals(true, wordDictionary.search(".ad")) // return True
        assertEquals(true, wordDictionary.search("b..")) // return True
    }

    @Test
    fun example2() {
        val wordDictionary = Problem_0211.WordDictionary()
        wordDictionary.addWord("bad")
        wordDictionary.addWord("dad")
        wordDictionary.addWord("mad")
        assertEquals(false, wordDictionary.search("rad")) // return False
        assertEquals(true, wordDictionary.search("bad")) // return True
        assertEquals(true, wordDictionary.search("mad")) // return True
        assertEquals(true, wordDictionary.search("...")) // return True
        assertEquals(false, wordDictionary.search("....")) // return True
    }
}
