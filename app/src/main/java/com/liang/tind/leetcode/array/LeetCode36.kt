package com.liang.tind.leetcode.array

/**
 * 有效的数独
 * https://leetcode.cn/problems/valid-sudoku/solution/
 */
class LeetCode36 {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        // 有效的数独满足以下三个条件：
        // 同一个数字在每一行只能出现一次；
        // 同一个数字在每一列只能出现一次；
        // 同一个数字在每一个小九宫格只能出现一次。

        // board 是9*9的表格，填入的数字是【1，9】
        // 用col[j][n] 记录第j列数字n出现的次数，row[i][n]第i行中数字n出现的次数，subboxes[i/3][i/3][n] 为每一个小宫格中出现n的次数
        // 只要有一个出现的次数大于1就是不符合的
        //                          这个9代表有9行
        val row = Array(9) {
            // 9代表数字是1-9
            IntArray(9)
        }

        val col = Array(9) {
            // 9代表数字是1-9
            IntArray(9)
        }

        val subBoxes = Array(3) {
            Array(3) {
                IntArray(9)
            }
        }

        for (i in 0 until 9) {
            for (j in 0 until 9) {
                val char = board[i][j]
                if (char == '.') continue
                val index = char - '1'
                row[i][index]++
                col[j][index]++
                subBoxes[i / 3][j / 3][index]++

                if (row[i][index] > 1 || col[j][index] > 1 || subBoxes[i / 3][j / 3][index] > 1) {
                    return false
                }
            }
        }

        return true
    }


}