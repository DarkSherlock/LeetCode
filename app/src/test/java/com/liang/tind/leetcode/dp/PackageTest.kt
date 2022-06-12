package com.liang.tind.leetcode.dp

import org.junit.Assert
import org.junit.Test

/**
 * @author: lonnie.liang
 * date: 2022/06/05 11:57
 */
class PackageTest {
    val c = 8
    val wArr = intArrayOf(0, 2, 3, 4, 5)
    val vArr = intArrayOf(0, 3, 4, 5, 8)

    @Test
    fun test1() {
        val sample = Package()
        val answer = sample.test(c, wArr, vArr)
        Assert.assertEquals(12, answer)
    }

    @Test
    fun test2() {
        val sample = Package()
        val answer = sample.test2(c, wArr, vArr)
        Assert.assertEquals(12, answer)
    }

}