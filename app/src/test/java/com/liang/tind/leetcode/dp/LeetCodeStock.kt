package com.liang.tind.leetcode.dp

import org.junit.Test

/**
 * @author: lonnie.liang
 * date: 2022/05/10 23:12
 * //https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/
 */
class LeetCodeStock {


    @Test
    fun test() {
        val prices = intArrayOf(1, 4, 2, 7)
        maxProfit309(prices)
    }

    /**
     * leetcode 121
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
     */
    fun maxProfit121(prices: IntArray): Int {

        // dp[i][k][s]代表第i天最多有K次交易次数限制的情况下持有股票或者不持有股票的利润s=sell or not
        // base case：
        //dp[-1][k][0] = dp[i][0][0] = 0 //第一天不持有的话 为0
        //dp[-1][k][1] = dp[i][0][1] = -infinity //第一天不可能卖 用-infinity标记
        //
        //状态转移方程：
        //dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
        //dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
        //此题的k一直=1
        //dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
        //dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][0] - prices[i])
        //由于base case dp[i][0][0] = 0所以 dp[i][1][1] = max(dp[i-1][1][1], 0 - prices[i])
        // k一直是1所以不需要这个维度了。
        //     dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i-1])
        //     dp[i][1] = Math.max(dp[i-1][1], -prices[i-1])


        // val dp = Array(prices.size+1) {
        //     IntArray(2)
        // }
        // dp[0][0] = 0
        // dp[0][1] = Int.MIN_VALUE
        // for(i in 1 .. prices.size) {
        //     dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i-1])
        //     dp[i][1] = Math.max(dp[i-1][1], -prices[i-1])
        // }

        // return dp[prices.size][0]

        var sell = 0
        var buy = Int.MIN_VALUE
        for (i in prices.indices) {
            sell = Math.max(sell, buy + prices[i])
            buy = Math.max(buy, -prices[i])
        }

        return sell
    }

    /**
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
     * leetcode 122
     */
    fun maxProfit122(prices: IntArray): Int {
        // base case：
        //dp[-1][k][0] = dp[i][0][0] = 0 //第一天不持有的话 为0
        //dp[-1][k][1] = dp[i][0][1] = -infinity //第一天不可能卖 用-infinity标记
        //dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1]+prices[i])
        //dp[i][k][1]= max(dp[i-1][k][1], dp[i-1][k-1][0]-prices[i])
        //此题没有限制交易限制，k视为无穷大，k=k-1,
        //dp[i][k][1]= max(dp[i-1][k][1], dp[i-1][k][0]-prices[i]) 此时k都一样可以化简不需要k

        // val dp = Array(prices.size+1) {
        //     IntArray(2)
        // }
        // dp[0][0] = 0
        // dp[0][1] = Int.MIN_VALUE
        // for(i in 1 .. prices.size) {
        //     dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i-1])
        //     dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i-1])
        // }

        // return dp[prices.size][0]

        var hold = Int.MIN_VALUE
        var unhold = 0
        for (i in 0 until prices.size) {
            val temp = unhold
            unhold = Math.max(unhold, hold + prices[i])
            hold = Math.max(hold, temp - prices[i])
        }

        return unhold
    }

    fun maxProfit309(prices: IntArray): Int {
        //dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
        //dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
        //解释：第 i 天选择 buy 的时候，要从 i-2 的状态转移，而不是 i-1 。
//        if (prices.size < 2) return 0
//
//        val dp = Array(prices.size + 1) {
//            IntArray(2)
//        }
//        dp[0][0] = 0
//        dp[0][1] = Int.MIN_VALUE
//        dp[1][0] = 0
//        dp[1][1] = -prices[0]
//        for (i in 2..prices.size) {
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1])
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i - 1])
//        }
//        return dp[prices.size][0]

        var hold = Int.MIN_VALUE
        var unhold = 0
        var preUnhold = 0
        for (i in 0 until prices.size) {
            val temp = unhold
            unhold = Math.max(unhold, hold + prices[i])
            hold = Math.max(hold, preUnhold - prices[i])
            preUnhold = temp
        }

        return unhold
    }

    /**
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
     */
    fun maxProfit714(prices: IntArray, fee: Int): Int {
//        val dp = Array(prices.size + 1) {
//            IntArray(2)
//        }
//        dp[0][0] = 0
//        dp[0][1] = Int.MIN_VALUE + fee //防止溢出
//        for (i in 1..prices.size) {
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1] - fee)
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1])
//        }
//
//        return dp[prices.size][0]
        var hold = Int.MIN_VALUE + fee //防止溢出
        var unhold = 0
        for (i in 0 until prices.size) {
            val temp = unhold
            unhold = Math.max(unhold, hold + prices[i] - fee)
            hold = Math.max(hold, temp - prices[i])
        }

        return unhold
    }

    /**
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/
     */
    fun maxProfit123(prices: IntArray): Int {
        // k = 2
        //dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1]+prices[i])
        //dp[i][k][1]= max(dp[i-1][k][1], dp[i-1][k-1][0]-prices[i])

        // base case
        //dp[-1][k][0] = dp[i][0][0] = 0 //第一天不持有的话 为0
        //dp[-1][k][1] = dp[i][0][1] = -infinity //第一天不可能卖 用-infinity标记
        val maxK = 2
        val dp = Array(prices.size + 1) {
            Array(maxK + 1) {
                IntArray(2)
            }
        }
        dp[0][0][0] = 0
        dp[0][1][0] = 0
        dp[0][2][0] = 0
        dp[0][0][1] = Int.MIN_VALUE
        dp[0][1][1] = Int.MIN_VALUE
        dp[0][2][1] = Int.MIN_VALUE
        for (i in 1..prices.size) {
            for (k in 1..maxK) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i - 1])
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i - 1])
            }
        }

        return dp[prices.size][maxK][0]
    }

}