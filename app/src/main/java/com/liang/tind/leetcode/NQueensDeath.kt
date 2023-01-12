package com.liang.tind.leetcode

import kotlin.math.abs

/**
 *@author: lonnie.liang
 *date: 2022/05/02 17:53
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击(即使其中任意两个皇后都不同列、同行和在一条斜线上)
 */
class NQueensDeath {

    fun test(n: Int) {
        val result = IntArray(n)
        res.clear()
        put(0, result)
        println("resultCount=${res.size}")
    }


    private val res = mutableListOf<List<String>>()
    fun solveNQueens(n: Int): List<List<String>> {
        res.clear()
        val result = IntArray(n) { -1 }
        put(0, result)
        return res
    }

    /**
     * 先把这个皇后放在第一行第一列，如果不冲突就继续摆放第二个皇后在第二行第一列，如果第二行第一列冲突就放第二行第二列
     * 直到不冲突为止
     */
    private fun put(currentRow: Int, result: IntArray) {
        val maxRow = result.size
        // NxN棋盘，所以maxRow=maxCol
        val maxCol = maxRow
        //放满n个了 输出结果
        if (currentRow == maxRow) {
            println("result: ${result.joinToString()}")
            val answer = mutableListOf<String>()
            for (item in result) {
                val chars = CharArray(maxCol) { '.' }
                // item就是皇后放在当前这一行的第几列
                chars[item] = 'Q'
                answer.add(String(chars))
            }
            res.add(answer)
            return
        }

        // 当前这个皇后尝试从第1列开始放 直到最后一列
        for (col in 0 until maxCol) {
            if (check(currentRow, col, result)) {
                result[currentRow] = col
                // 如果当前这次放置是有效的，继续放置下一个皇后
                put(currentRow + 1, result)
                result[currentRow] = -1
            }
        }
    }

    /**
     * return true: 任意两个皇后都不同列、同行和在一条斜线上
     */
    private fun check(currentRow: Int, currentCol: Int, result: IntArray): Boolean {

        for (i in 0 until currentRow) {
            // 和之前任意一个皇后是同一列
            val isSameCol = result[i] == currentCol
            // 和之前任意一个皇后是同一对角线, diffX和diffY相等即斜率相同为在同一对角线
            val isSameDiagonal = (abs(result[i] - currentCol) == abs(i - currentRow))
            if (isSameCol || isSameDiagonal) {
                return false
            }
        }
        return true
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            NQueensDeath().test(8)
        }
    }
}