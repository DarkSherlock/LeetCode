package com.liang.tind.leetcode

import java.util.*
import kotlin.collections.ArrayList

/**
 * @author: lonnie.liang
 * date: 2022/05/20 23:33
 * https://leetcode.cn/problems/rotate-image/submissions/
 */
class LeetCode48 {

    fun rotate(matrix: Array<IntArray>): Unit {
        val m = matrix.size
        val n = matrix.firstOrNull()?.size ?: 0
        for (i in 0 until m / 2) {
            val a = matrix[i]
            val b = matrix[m - 1 - i]
            for (j in 0 until n) {
                val temp = a[j]
                a[j] = b[j]
                b[j] = temp
            }
        }

        for(i in 0 until n) {
            for(j in 0 until i) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }
        }
    }
}