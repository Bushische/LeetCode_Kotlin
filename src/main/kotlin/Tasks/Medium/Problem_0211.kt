package leetcode.tasks.medium

class Problem_0211 {
    /* 211. Design Add and Search Words Data Structure
    URL: https://leetcode.com/problems/design-add-and-search-words-data-structure/

Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.

Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True


Constraints:

1 <= word.length <= 25
word in addWord consists of lowercase English letters.
word in search consist of '.' or lowercase English letters.
There will be at most 2 dots in word for search queries.
At most 10^4 calls will be made to addWord and search.
     */

    class WordDictionary {
        /* IDEA: idea is to use TRIE for storage information about words
         * For add - just add a new word to the trie
         * For search - make search and if there is `.`, make following search for every branch
         */

        private val trie: Trie

        init {
            trie = Trie()
        }

        fun addWord(word: String) {
            trie.addWord(word)
        }

        fun search(word: String): Boolean = trie.search(word)

        // ----

        /**
         * Class to keep Trie
         * If the node final, we have a word's end
         * @param isFinal to mark word end
         */
        private class Trie {
            var isFinal: Boolean = false
            val branches: MutableMap<Char, Trie> = mutableMapOf()

            /** Add a new word to the Trie */
            fun addWord(word: String) {
                if (word.isNullOrEmpty()) {
                    this.isFinal = true
                } else {
                    val head = word[0]
                    val nextWord = word.substring(1)
                    println("Trie add: head=`$head` nextWord=`$nextWord`")

                    val nextTrie = if (branches.containsKey(head)) branches[head] else Trie()
                    branches.set(head, nextTrie!!)
                    nextTrie.addWord(nextWord)
                }
            }

            /** Check presence of the word in Trie */
            fun search(word: String): Boolean {
                if (word.isNullOrEmpty()) {
                    return this.isFinal
                }
                val head = word[0]
                val nextWord = word.substring(1)
                if (head == '.') {
                    var res = false
                    for (branch in branches.values) {
                        res = res || branch.search(nextWord)
                    }
                    return res
                } else {
                    if (!branches.containsKey(head)) {
                        return false
                    }
                    return branches[head]?.search(nextWord) ?: false
                }
            }
        }
    }

    /**
     * Your WordDictionary object will be instantiated and called as such:
     * var obj = WordDictionary()
     * obj.addWord(word)
     * var param_2 = obj.search(word)
     */
}
