package com.liang.tind.leetcode.backtrace

import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import org.junit.Assert
import org.junit.Test
import java.util.*
import kotlin.collections.ArrayList

/**
 * @author: lonnie.liang
 * date: 2022/05/20 23:33
 * https://leetcode.cn/problems/ones-and-zeroes/
 */
class LeetCode474 {

    fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
        //https://programmercarl.com/0494.%E7%9B%AE%E6%A0%87%E5%92%8C.html#%E6%80%9D%E8%B7%AF
        // https://leetcode.cn/problems/ones-and-zeroes/solution/yi-he-ling-by-leetcode-solution-u2z2/ 推荐
        // 子集看作一个背包，定义dp[i][j][k]：对于前i个字符串中j个0k个i的item有多少个，
        // 最后返回dp[strs.lenth][m][n], base case dp[0][j][k] = 0
        // 我们需要统计每个strings的0和1个数
        // dp[i][j][k] = max(dp[i][j][k], dp[i-1][j-zeroNum][k-oneNum]+1)
        //采用滚动数组
        val dp = Array(m + 1) {
            IntArray(n + 1)
        }

        for (str in strs) {
            var zeroNum = 0
            var oneNum = 0
            for (char in str.toCharArray()) {
                if (char == '0') {
                    zeroNum++
                } else {
                    oneNum++
                }
            }
            var j = m
            while (j >= zeroNum) {
                var k = n
                while (k >= oneNum) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeroNum][k - oneNum] + 1)
                    k--
                }
                j--
            }
        }

        return dp[m][n]
    }
}