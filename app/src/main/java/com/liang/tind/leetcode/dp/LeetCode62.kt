package com.liang.tind.leetcode.dp

import java.util.*

/**
 *
 *
 * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 */
class LeetCode62 {

    fun uniquePaths(m: Int, n: Int): Int {
        // dp[i][j] 为到i行j列有多少种方式 = dp[i-1][j] + dp[i][j-1]
        // dp[0][j] = 1, dp[i][0] = 1
        val dp = Array(m) {
            IntArray(n)
        }

        for (i in 0 until m) {
            dp[i][0] = 1
        }

        for (j in 0 until n) {
            dp[0][j] = 1
        }

        for (i in 1 until m) {
            for (j in 1 until n) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
            }
        }

        return dp[m-1][n-1]

    }


}