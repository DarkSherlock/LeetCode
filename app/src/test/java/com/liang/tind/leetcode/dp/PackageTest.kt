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

        /**
         * 5=5
        5=2+2+1
        5=2+1+1+1
        5=1+1+1+1+1
         */
        val testArr = intArrayOf(1, 2, 5)
        change(5, testArr)
    }

    fun change(amount: Int, coins: IntArray): Int {
        //https://programmercarl.com/0518.%E9%9B%B6%E9%92%B1%E5%85%91%E6%8D%A2II.html#%E6%80%9D%E8%B7%AF
        val dp = IntArray(amount + 1)
        dp[0] = 1
        for (coin in coins) {
            println(dp.joinToString())
            for (i in coin..amount) {
                dp[i] += dp[i - coin]
            }
        }
        println(dp.joinToString())
        return dp[amount]
    }

    fun maxProfit(prices: IntArray): Int {
        //https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/
        // dp[i][k][s]代表第i天最多有K次交易次数限制的情况下持有股票或者不持有股票的利润s=sell or not
        //这里没有限制交易次数 k不要 变成2维数组
        //
//        val dp = Array(prices.size+1) {
//            IntArray(2)
//        }
//        dp[0][0] = 0
//        dp[0][1] = Int.MIN_VALUE
//        for(i in 1 .. prices.size) {
//            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i-1])
//            dp[i][1] = Math.max(dp[i-1][1], -prices[i-1])
//        }
//
//        return dp[prices.size][0]

        var sell = 0
        var buy = -prices[0]
        for (i in 1 until prices.size) {
            sell = Math.max(sell, buy + prices[i])
            buy = Math.max(buy, -prices[i])
        }

        return sell
    }
}