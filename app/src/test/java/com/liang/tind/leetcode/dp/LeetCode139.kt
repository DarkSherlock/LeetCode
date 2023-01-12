package com.liang.tind.leetcode.dp

/**
 * @author: lonnie.liang
 * date: 2022/05/20 23:33
 * https://leetcode.cn/problems/word-break/
 * https://programmercarl.com/0139.%E5%8D%95%E8%AF%8D%E6%8B%86%E5%88%86.html#%E6%80%9D%E8%B7%AF
 */
class LeetCode139 {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        // dp[i]为前i个字符是否能被拆分。s相当于背包，最后返回[s.length], wordDict相当于物品
        //dp[i] = dp[i-word.length] && word.equals(s.substring(i-word.length, i)
        val wordSet = HashSet<String>(wordDict)
        val dp = BooleanArray(s.length + 1)
        dp[0] = true//为了递推公式
        for (i in 1..s.length) {
            for (j in 0..i) {
                val word = s.substring(j, i)
                if (dp[i - word.length] && wordSet.contains(word)) {
                    dp[i] = true
                    break
                }
            }
        }
        return dp[s.length]
    }
}