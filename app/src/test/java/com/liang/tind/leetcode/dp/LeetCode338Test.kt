package com.liang.tind.leetcode.dp

import org.junit.Assert
import org.junit.Test

/**
 * @author: lonnie.liang
 * date: 2022/05/10 17:29
 */
class LeetCode338Test {


    @Test
    fun test() {
        val test = LeetCode338()
        testSolution { test.solution1(it) }
        testSolution { test.solution2(it) }
    }


    private fun testSolution(solution: (n: Int) -> IntArray) {
        var n = 0
        var ans = solution(n)
        check(n, ans)

        n = 1
        ans = solution(n)
        check(n, ans)
        n = 2
        ans = solution(n)
        check(n, ans)
        n = 5
        ans = solution(n)
        check(n, ans)
    }

    private fun check(n: Int, answer: IntArray) {
        Assert.assertEquals(n + 1, answer.size)
        when (n) {
            0 -> {
                Assert.assertEquals(0, answer[0])
            }
            1 -> {
                Assert.assertEquals(0, answer[0])
                Assert.assertEquals(1, answer[1])
            }
            2 -> {
                Assert.assertEquals(0, answer[0])
                Assert.assertEquals(1, answer[1])
                Assert.assertEquals(1, answer[2])

            }
            5 -> {
                Assert.assertEquals(0, answer[0])
                Assert.assertEquals(1, answer[1])
                Assert.assertEquals(1, answer[2])
                Assert.assertEquals(2, answer[3])
                Assert.assertEquals(1, answer[4])
                Assert.assertEquals(2, answer[5])
            }
        }
    }
}