package com.liang.tind.leetcode.dp

/**
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 *
 *
 * 输入：n = 2
 * 输出：[0,1,1]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 *
 *
 * 输入：n = 5
 * 输出：[0,1,1,2,1,2]
 * 解释：
 * 0 --> 000
 * 1 --> 001
 * 2 --> 010
 * 3 --> 011
 * 4 --> 100
 * 5 --> 101
 */
class LeetCode338 {


    fun solution1(n: Int): IntArray {
        if (n == 0) return IntArray(1)
        val result = IntArray(n + 1)
        for (i in 0..n) {
            result[i] = countOnes(i)
        }
        return result
    }

    private fun countOnes(i: Int): Int {
        var x = i
        var ones = 0
        while (x > 0) {
            // x and x - 1 这个运算会把最后一个1变为0，比如x= 101, 101 & (101-1) = 101 & 100 = 100, 直到=0，这个次数就是1的数量
            x = x and x - 1
            ones++
        }
        return ones
    }

    fun solution2(n: Int): IntArray {
        val result = IntArray(n + 1)
        // 利用动态规划思路，result[i] = result[(i and i - 1)] + 1, 比如i= 101, 那么i的1个个数就是i and i - 1 = 100 的个数 +1
        for (i in 1..n) {
            result[i] = result[(i and i - 1)] + 1
        }
        return result
    }
}