package com.liang.tind.leetcode.dp

/**
 * @author: lonnie.liang
 * date: 2022/05/20 23:33
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/?favorite=2ckc81c
 */
class LeetCode3 {
    fun lengthOfLongestSubstring(s: String): Int {
        // 只能用滑动窗口。
        // https://leetcode.cn/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetc-2/
        var ans = 1
        var right = -1
        val set = mutableSetOf<Char>()
        for (i in 0 until s.length) {
            if (i != 0) {
                set.remove(s[i - 1])
            }

            while (right + 1 < s.length && !set.contains(s[right + 1])) {
                right++
                set.add(s[right])
            }

            ans = Math.max(ans, right - i + 1)
        }

        return ans
    }
}