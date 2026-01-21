package leetcode.tasks.medium

import leetcode.models.TreeNode
import kotlin.IllegalStateException
import kotlin.collections.ArrayDeque
// import java.util.Stack

class Problem_0173 {
    /* 173. Binary Search Tree Iterator
    URL: https://leetcode.com/problems/binary-search-tree-iterator/description/

Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):

BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
int next() Moves the pointer to the right, then returns the number at the pointer.
Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.

You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.

Example 1:
Input
["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
[[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
Output
[null, 3, 7, true, 9, true, 15, true, 20, false]

Explanation
BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
bSTIterator.next();    // return 3
bSTIterator.next();    // return 7
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 9
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 15
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 20
bSTIterator.hasNext(); // return False

Constraints:

The number of nodes in the tree is in the range [1, 10^5].
0 <= Node.val <= 10^6
At most 10^5 calls will be made to hasNext, and next.


Follow up:

Could you implement next() and hasNext() to run in average O(1) time and use O(h) memory, where h is the height of the tree?
     */

    public class BSTIterator(
        root: TreeNode?,
    ) {
        val stack = ArrayDeque<TreeNode>()

        // constructor
        init {
            fillStack(root)
        }

        fun next(): Int {
            var result = stack.removeLast()
            val returnResult = result.`val`
            fillStack(result.right)
            return returnResult
        }

        fun hasNext(): Boolean = stack.isNotEmpty()

        private fun fillStack(node: TreeNode?) {
            if (node != null) {
                stack.add(node)
                fillStack(node.left)
            }
        }
    }

    public class BSTIteratorv1(
        root: TreeNode?,
    ) {
        fun next(): Int {
            val returnValue = currentTreeNode?.`val` ?: throw IllegalStateException()
            // println("current: $returnValue")
            currentTreeNode = selectNextNode(currentTreeNode?.right)

            return returnValue
        }

        fun hasNext(): Boolean {
            val result = (currentTreeNode != null)
            // (currentTreeNode?.right != null) ||
            //     (stack.any())
            // println("current: ${currentTreeNode?.`val`} with hasNext: $result")
            return result
        }

        // -- private implementation
        val stack: ArrayDeque<TreeNode> = ArrayDeque<TreeNode>()
        var currentTreeNode: TreeNode? = selectNextNode(root) // the first left node should be returned

        // Go to the most left node with filling the stack
        private fun selectNextNode(lroot: TreeNode?): TreeNode? {
            if (lroot?.left != null) {
                stack.add(lroot)
                return selectNextNode(lroot.left)
            }
            if (lroot == null) {
                if (stack.isEmpty()) return null
                return stack.removeLast()
            }
            return lroot
        }
    }

// manual test
//     5
//   3   7
// 1    6  8

// cn: 8
// st:
// pr: 1, 3, 5, 6, 7, 8

/**
     * Your BSTIterator object will be instantiated and called as such:
     * var obj = BSTIterator(root)
     * var param_1 = obj.next()
     * var param_2 = obj.hasNext()
     */

    // better version from: https://leetcode.com/problems/binary-search-tree-iterator/solutions/
    // class BSTIterator_2(
    //     root: TreeNode?,
    // ) {
    //     val stack = Stack<TreeNode>()

    //     init {
    //         pushLeft(root)
    //     }

    //     fun next(): Int {
    //         val node = stack.pop()
    //         node.right?.let { pushLeft(it) }
    //         return node.`val`
    //     }

    //     fun hasNext(): Boolean = stack.isNotEmpty()

    //     private fun pushLeft(node: TreeNode?) {
    //         var current = node
    //         while (current != null) {
    //             stack.push(current)
    //             current = current.left
    //         }
    //     }
    // }
}
