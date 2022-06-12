package com.liang.tind.leetcode.dp

import org.junit.Assert
import org.junit.Test

/**
 * @author: lonnie.liang
 * date: 2022/05/10 17:29
 */
class LeetCode1025Test {


    @Test
    fun test() {
        val test = LeetCode1025()
        Assert.assertTrue(!test.solution(1))
        Assert.assertTrue(test.solution(2))
        Assert.assertTrue(!test.solution(3))
        Assert.assertTrue(test.solution(4))
        Assert.assertTrue(!test.solution(5))
    }

    @Test
    fun testFn() {
        Assert.assertEquals(2, fn(3))
    }

    private fun fn(n: Int): Int {
        val dp = IntArray(n + 2)
        dp[1] = 1
        for (i in 2..n) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }
        return dp[n]
    }

}