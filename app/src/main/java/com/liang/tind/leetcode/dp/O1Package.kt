package com.liang.tind.leetcode.dp

import kotlin.math.max

/**
 *@author: lonnie.liang
 *date: 2022/05/08 22:56
 * 动态规划 01背包问题
 * https://www.bilibili.com/video/BV1g7411B7SP?spm_id_from=333.999.0.0
 * https://www.bilibili.com/video/BV1BU4y177kY?share_source=copy_web
 * https://www.bilibili.com/video/BV1C7411K79w?p=1（推荐）
 * 假设现有4个物品，小偷背包容量为8，怎么可以头的价值最大的物品
 * 物品编号： 1 2 3 4
 * 物品重量： 2 3 4 5
 * 物品价值： 3 4 5 8
 */
class O1Package {

    fun test(capacity: Int, weightArray: IntArray, valueArray: IntArray): Int {
        /*
         * 定义f(k,w)为当背包容量为w并且现有k件物品，从前k件物品任取 可以偷得的最大价值， 本题所求即f(4,8)
         * f(4,8)可以被分解为
         *   1.如果还有剩余空间偷当前物品的时候 f(3,3) + 8(第四件物品重量为5，价值为8) 和 f(3, 8)(如果不偷第四件物品的情况) 最大值
         *   2.如果没有剩余空间偷当前物品的时候 f(3, 8)
         * f(k,w) = max(f(k-1, w-w[k]) + v[k], f(k-1,w)), w[k]<=w
         *          f(k-1,w), w[k]>w
         *
         * 行表示当前有多少个物品(k), 列表示当前背包容量
         * 没有物品时第0行所能偷到的价值都是0，第0列没有背包容量时也都是0
         * f(1,1) 因为w[1] = 2,大于w=1，所以f(1,1) = f(0,1) = 0
         *            0 1       2 3 4 5 6 7 8
         * 0          0 0       0 0 0 0 0 0 0
         * 1(w=2,v=3) 0 f(1,1)
         * 2(w=3,v=4) 0
         * 3(w=4,v=5) 0
         * 4(w=5,v=8) 0                     f(4,8)
         *
         * 填满表格结果：
         *  0	0	0	0	0	0	0	0	0
         *  0	0	3	3	3	3	3	3	3
         *  0	0	3	4	4	7	7	7	7
         *  0	0	3	4	5	7	8	9	9
         *  0	0	3	4	5	8	8	11	12
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
                    val value1 = f[i - 1][remindW] + valueArray[i]
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

        println("f[4][8]:${f[k][w]}")
        return f[k][w]
    }

    fun test2(capacity: Int, weightArray: IntArray, valueArray: IntArray): Int {

        val dp = IntArray(capacity + 1)

        for (i in 1 until weightArray.size) {
            for (j in capacity downTo 1) {
                if (j >= weightArray[i]) {
                    dp[j] = Math.max(dp[j], dp[j - weightArray[i]] + valueArray[i])
                }
            }
        }

        return dp[capacity]
    }
}