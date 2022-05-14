package com.liang.tind.leetcode.dp

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *          1
 *         1 1
 *        1 2 1
 *       1 3 3 1
 *      1 4 6 4 1
 * https://leetcode.cn/problems/pascals-triangle/
 * sample1:
 *  输入: numRows = 5
 *  输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * sample2:
 *  输入: numRows = 1
 *  输出: [[1]]
 */
class LeetCode118 {

    fun generate(numRows: Int): List<List<Int>> {
        /**
         * base情况：nowRows =1 return [[1]]
         * base情况：nowRows = 2 return [[1],[1,1]]
         * 从第三行开始，初始化一个 dp[i][j], dp[i][0] = dp[i][n-1]= 1
         * 遍历j in [1, n) dp[i][j]= dp[i-1][j-1] + dp[i-1][j]
         */

        val answer = mutableListOf<List<Int>>()
        answer.add(listOf(1))
        if (numRows == 1) return answer
        answer.add(listOf(1, 1))
        if (numRows == 2) return answer

        for (i in 3..numRows) {
            val row = mutableListOf(1)
            for (j in 1 until i - 1) {
                // 第一个-1是想获取上一行的，第二个-1 是因为下标是从1开始算的而answer是从0开始计算
                row.add((answer[i - 1 - 1][j - 1] + answer[i - 1 - 1][j]))
            }
            row.add(1)
            answer.add(row)
        }

        return answer
    }

}