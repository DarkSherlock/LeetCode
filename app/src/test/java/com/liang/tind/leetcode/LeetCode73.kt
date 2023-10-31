package com.liang.tind.leetcode

/**
 * @author: lonnie.liang
 * date: 2022/05/20 23:33
 * https://leetcode.cn/problems/set-matrix-zeroes/
 */
class LeetCode73 {

    fun setZeroes(matrix: Array<IntArray>) {
        // 第一次遍历使用两个数组booleanArr row,col分别记录这一行或者列是否需要重置0
        // 第二次遍历 再去reset to 0
        val m = matrix.size
        val n = matrix[0].size
        val row = BooleanArray(m)
        val col = BooleanArray(n)
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (matrix[i][j] == 0) {
                    row[i] = true
                    col[j] = true
                }
            }
        }

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0
                }
            }
        }

    }

    fun setZeroes1(matrix: Array<IntArray>) {
        // 我们可以使用第一行和第一列来代替上面的row col数组，预先用2个标记变量记录第一行和第一列是否需要set zero,
        // 处理完毕以后 其他行列后再根据这2个变量处理第一行和第一列
        val m = matrix.size
        val n = matrix.first().size
        var flagCol = false
        var flagRow = false

        for (i in 0 until m) {
            if (matrix[i][0] == 0) {
                flagCol = true
                break
            }
        }

        for (i in 0 until n) {
            if (matrix[0][i] == 0) {
                flagRow = true
                break
            }
        }

        for (i in 1 until m) {
            for (j in 1 until n) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0
                    matrix[i][0] = 0
                }
            }
        }

        for (i in 1 until m) {
            for (j in 1 until n) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0
                }
            }
        }

        if (flagCol) {
            for (i in 0 until m) {
                matrix[i][0] = 0
            }
        }
        if (flagRow) {
            for (i in 0 until n) {
                matrix[0][i] = 0
            }
        }
    }
}