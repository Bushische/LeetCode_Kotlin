package leetcode.tasks.medium

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.emptyArray

class Problem_0225Test {
    @Test
    fun example1() {
        val myStack = Problem_0225.MyStack()

        myStack.push(1)
        myStack.push(2)
        assertEquals(2, myStack.top()) // return 2
        assertEquals(2,myStack.pop()) // return 2
        assertEquals(false, myStack.empty()) // return False
        assertEquals(1, myStack.pop())
        assertTrue(myStack.empty())
    }
}