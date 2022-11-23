package com.liang.tind.leetcode.dp

import org.junit.Assert
import org.junit.Test


/**
 * @author: lonnie.liang
 * date: 2022/05/10 22:35
 */
class LeetCodeLCP07Test {

    @Test
    fun test() {
        val test = LeetCodeLCP07()
        var n = 5
        var relations = arrayOf(
            intArrayOf(0, 2),
            intArrayOf(2, 1),
            intArrayOf(3, 4),
            intArrayOf(2, 3),
            intArrayOf(1, 4),
            intArrayOf(2, 0),
            intArrayOf(0, 4)
        )
        var k = 3

        var numWays = test.numWays(n, relations, k)
        Assert.assertEquals(3, numWays)

        n = 3
        relations = arrayOf(
            intArrayOf(0, 2),
            intArrayOf(2, 1)
        )
        k = 2

        numWays = test.numWays(n, relations, k)
        Assert.assertEquals(0, numWays)
    }
}