package com.liang.tind.leetcode.dp

import kotlin.math.max

/**
 *@author: lonnie.liang
 *date: 2022/05/08 22:56
 * 动态规划 完全背包问题
 *
 * https://www.bilibili.com/video/BV1C7411K79w?p=2（推荐）
 * 、
 */
class Package {

    fun test(capacity: Int, weightArray: IntArray, valueArray: IntArray): Int {
        /*
         *  填满表格结果：
         * w v  0   1   2   3   4   5   6   7   8(背包容量)
         * 0 0  0	0	0	0	0	0	0	0	0
         * 2 3  0	0	3	3	6	6	9	9	12
         * 3 4  0	0	3	4	6	7	9	10	12
         * 4 5  0	0	3   4   6   7   9   10  12
         * 5 8  0	0	3   4   6   8   9   11  12
         *
         */
        val k = weightArray.size - 1
        val w = capacity

        val f = Array(weightArray.size) {
            IntArray(capacity + 1)
        }

        for (i in 1 until weightArray.size) {
            for (j in 1..capacity) {
                f[i][j] = if (weightArray[i] > j) {
                    f[i - 1][j]
                } else {
                    val remindW = j - weightArray[i] //剩余的 多少重量
                    val value1 = f[i][remindW] + valueArray[i]
                    max(value1, f[i - 1][j])
                }
            }
        }

        println("表格结果：")
        f.forEach { colArr ->
            colArr.forEach { col ->
                print("$col\t")
            }
            println()
        }

        return f[k][w]
    }

    fun test2(capacity: Int, weightArray: IntArray, valueArray: IntArray): Int {

        val dp = IntArray(capacity + 1)

        for (i in 1 until weightArray.size) {
            for (j in 1..capacity) {
                if (j >= weightArray[i]) {
                    dp[j] = Math.max(dp[j], dp[j - weightArray[i]] + valueArray[i])
                }
            }

            println("滚动数组 dp:${dp.joinToString()}")
        }

        return dp[capacity]
    }


}