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
        //参考https://leetcode.cn/problems/palindromic-substrings/
        val n = s.length
        val dp = Array(n) {
            BooleanArray(n)
        }
        // dp[i][j]代表[i,j]的这一个字符串是否是回文串,通过2个foreach统计出所有情况.
        // 这里dp不能代表回文串个数,因为确定不了状态转移,比如dp[0]只有一个,dp[1]有多少个并不能转移得到.
        //dp[i][j]只有当si == sj && (j-i<2 || dp[i+1][j-1]) 的时候为true
        var begin = 0
        var end = 1
        for (j in 0 until n) {
            for (i in 0..j) {
                if (s[i] == s[j] && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true
                    if(j+1-i > end - begin) {
                        begin = i
                        end = j+1
                    }
                }
            }
        }
        return s.substring(begin, end)
    }

    fun countSubstrings(s: String): Int {
        val n = s.length
        val dp = Array(n) {
            BooleanArray(n)
        }
        // dp[i][j]代表[i,j]的这一个字符串是否是回文串,通过2个foreach统计出所有情况.
        // 这里dp不能代表回文串个数,因为确定不了状态转移,比如dp[0]只有一个,dp[1]有多少个并不能转移得到.
        //dp[i][j]只有当si == sj && (j-i<2 || dp[i+1][j-1]) 的时候为true
        var count = 0
        for (j in 0 until n) {
            for (i in 0..j) {
                if (s[i] == s[j] && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true
                    count++
                }
            }
        }

        return count
    }
}