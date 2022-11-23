package com.liang.tind.leetcode.dp

import org.junit.Assert
import org.junit.Test

/**
 * @author: lonnie.liang
 * date: 2022/05/10 23:12
 */
class LeetCode118Test {

    @Test
    fun test() {
        val test = LeetCode118()
        var n = 1
        var answer = test.generate(n)
        Assert.assertEquals(n, answer.size)
        Assert.assertEquals(1, answer[0].size)
        Assert.assertEquals(1, answer[0][0])

        n = 2
        answer = test.generate(n)
        Assert.assertEquals(n, answer.size)
        Assert.assertEquals(1, answer[0].size)
        Assert.assertEquals(1, answer[0][0])
        Assert.assertEquals(2, answer[1].size)
        Assert.assertEquals(1, answer[1][0])
        Assert.assertEquals(1, answer[1][1])

        n = 5
        answer = test.generate(n)
        Assert.assertEquals(n, answer.size)
        Assert.assertEquals(1, answer[0].size)
        Assert.assertEquals(1, answer[0][0])
        Assert.assertEquals(2, answer[1].size)
        Assert.assertEquals(1, answer[1][0])
        Assert.assertEquals(1, answer[1][1])
        Assert.assertEquals(3, answer[2].size)
        Assert.assertEquals(1, answer[2][0])
        Assert.assertEquals(2, answer[2][1])
        Assert.assertEquals(1, answer[2][2])
        Assert.assertEquals(4, answer[3].size)
        Assert.assertEquals(1, answer[3][0])
        Assert.assertEquals(3, answer[3][1])
        Assert.assertEquals(3, answer[3][2])
        Assert.assertEquals(1, answer[3][3])
        Assert.assertEquals(5, answer[4].size)
        Assert.assertEquals(1, answer[4][0])
        Assert.assertEquals(4, answer[4][1])
        Assert.assertEquals(6, answer[4][2])
        Assert.assertEquals(4, answer[4][3])
        Assert.assertEquals(1, answer[4][4])
    }
}