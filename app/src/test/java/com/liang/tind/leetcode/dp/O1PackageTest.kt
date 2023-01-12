package com.liang.tind.leetcode.dp

import org.junit.Assert
import org.junit.Test

/**
 * @author: lonnie.liang
 * date: 2022/06/05 11:57
 */
class O1PackageTest {
    val c = 8
    val wArr = intArrayOf(0, 2, 3, 4, 5)
    val vArr = intArrayOf(0, 3, 4, 5, 8)

    @Test
    fun test1() {

        val sample = O1Package()
        val answer = sample.test(c, wArr, vArr)
        Assert.assertEquals(12, answer)
    }

    @Test
    fun test2() {
        val sample = O1Package()
        val answer = sample.test2(c, wArr, vArr)
        Assert.assertEquals(12, answer)
        val answer2 = solution2(intArrayOf(2, 3, 4, 5), intArrayOf(3, 4, 5, 8), c)
        val answer1 = solution1(intArrayOf(2, 3, 4, 5), intArrayOf(3, 4, 5, 8), c)
        Assert.assertEquals(12, answer2)
        Assert.assertEquals(12, answer1)
    }

    private fun solution1(w: IntArray, v: IntArray, capacity: Int): Int {
        val dp = Array(w.size + 1) {
            IntArray(capacity + 1)
        }
        //dp[i][j] 代表有【0，i】件物品 背包容量为j的时候装得下的 最大价值
        // base case dp[0][j] =0,没有物品的时候只能是0，dp[i][0] = 0没有容量的时候也只能为0
        for (i in 1..w.size) {
            for (j in 1..capacity) {
                val currentIndex = i - 1//这里减一是因为w是从0开始而dp是从1开始
                dp[i][j] = if (j < w[currentIndex]) {
                    //当前的容量小于当前物品的重量，装不下，只能=与上个值
                    dp[i - 1][j]//这个减一是因为要取上一个结果。
                } else {
                    Math.max(dp[i - 1][j], dp[i - 1][j - w[currentIndex]] + v[currentIndex])
                }
            }
        }

        println("二维数组：")
        dp.forEach { colArr ->
            colArr.forEach { col ->
                print("$col\t")
            }
            println()
        }

        return dp[w.size][capacity]
    }

    private fun solution2(w: IntArray, v: IntArray, capacity: Int): Int {
        println("滚动数组:")
        val dp = IntArray(capacity + 1)
        for (i in w.indices) {
            println(dp.joinToString())
            for (j in capacity downTo 1) {
                if (j >= w[i]) {
                    dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i])
                }
            }
        }
        println(dp.joinToString())
        return dp[capacity]
    }


}