package com.liang.tind.leetcode

import org.junit.Test

/**
 *@author: lonnie.liang
 *date: 2022/05/08 15:50
 *
 */

class StringTest {

    @Test
    fun revertStringTest() {
        val s = "abcdefg"
        revertString(s, 0)
    }

    private fun revertString(s: String, current: Int) {
        if (current + 1 < s.length) {
            revertString(s, current + 1)
        }
        println(s[current])
    }
}