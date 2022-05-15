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
    
}