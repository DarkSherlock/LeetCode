package com.liang.tind.leetcode.strings

/**
 *@author: lonnie.liang
 *date: 2022/05/26 22:10
 * https://leetcode.cn/problems/longest-palindromic-substring/
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 */
class LeetCode5 {


    fun solution(s: String): String {
        if (s.length < 2) {
            return s
        }
        var begin = 0
        var maxLen = 1
        val len = s.length
        // dp[i][j] 代表s[i,j]是否是回文串， 边界条件s[i,i]即长度为1时都是回文串
        // 转移方程：1。s[i] != s[j] 首尾不相等 即不是回文
        //         2.1首尾相等的情况下，去掉首尾如果还剩1个字符或者0个字符 那么是
        //         2.2 首尾相等的情况下 还剩多个字符，那么 dp[i][j] = dp[i+1][j-1]

        val dp = Array(len) {
            BooleanArray(len)
        }

        for (i in 0 until len) {
            // 边界条件s[i,i]即长度为1时都是回文串
            dp[i][i] = true
        }

        //开始递推，枚举所有长度情况，长度为2，长度为3 。。。 长度为len的子串
        for (L in 2..len) {
            // i为左边界
            for (i in 0 until len) {
                // L= j + 1 - i, 这里s[i,j] j是闭区间所以要+1，s[0,1]情况下j = L-1+i = 2-1+0 = 1
                val j = L - 1 + i
                if (j >= len) {
                    // 右边界超过的话 就结束这个长度的遍历
                    break
                }

                dp[i][j] = if (s[i] != s[j]) {
                    false
                } else {
                    if (j - i < 3) {
                        // 首尾相等的情况下，去掉首尾如果还剩1个字符或者0个字符 那么是
                        true
                    } else {
                        // 2.2 首尾相等的情况下 还剩多个字符，那取决于子串是否是
                        dp[i + 1][j - 1]
                    }
                }

                // 更新maxLen
                if (dp[i][j] && L > maxLen) {
                    maxLen = L
                    begin = i
                }
            }
        }

        return s.substring(begin, maxLen + begin)
    }

    fun setZeroes(matrix: Array<IntArray>): Unit {
        // 第一次遍历使用两个数组booleanArr row,col分别记录这一行或者列是否需要重置0
        //。第二次遍历 再去reset to 0
        val m = matrix.size
        val n = matrix[0].size
        val row = BooleanArray(m)
        val col = BooleanArray(n)
        for(i in 0 until m) {
            for(j in 0 until n) {
                if(matrix[i][j] == 0) {
                    row[i] = true
                    col[j] = true
                }
            }
        }

        for(i in 0 until m) {
            for(j in 0 until n) {
                if(row[i] || col[j] ) {
                    matrix[i][j] = 0
                }
            }
        }

    }
}