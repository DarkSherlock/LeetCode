package com.liang.tind.leetcode.strings

import com.liang.tind.leetcode.LinkList.LinkList
import java.util.*
import kotlin.collections.ArrayList

/**
 *@author: lonnie.liang
 *date: 2022/05/26 22:10
 * https://leetcode.cn/problems/palindrome-partitioning/
 * 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 *  输入：s = "aab"
 *  输出：[["a","a","b"],["aa","b"]]
 */
class LeetCode131 {
    val res = mutableListOf<List<String>>()
    val list= LinkedList<String>()
    fun solution(s: String): List<List<String>> {
        // "google", start =0,可以分割出g, go, goo, goog, googl, google六个字串 选取符合的加入到res中

        dfs(s, 0)
        return res
    }

    private fun dfs(s: String, startIndex: Int) {
        if (startIndex == s.length) {
            res.add(ArrayList(list))
            return
        }

        for (i in startIndex until s.length) {
            val subString = s.substring(startIndex, i + 1)
            if (check(subString)) {
                list.add(subString)
                dfs(s, i + 1)
                list.removeLast()
            }
        }
    }

    private fun check(s: String, start: Int = 0, end: Int = s.length - 1): Boolean {
        var left = start
        var right = end
        while (left < right) {
            if (s[left] != s[right]) return false
            left++
            right--
        }
        return true
    }
}