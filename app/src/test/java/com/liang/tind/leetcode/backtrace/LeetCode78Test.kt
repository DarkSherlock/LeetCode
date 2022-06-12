package com.liang.tind.leetcode.backtrace

import org.junit.Test

/**
 * @author: lonnie.liang
 * date: 2022/05/20 23:33
 */
class LeetCode78Test {

    @Test
    fun test() {
        val sample = LeetCode78()
        val result = sample.subsets(intArrayOf(1, 2, 3))
        println(result)
    }
}