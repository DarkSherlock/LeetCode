package com.liang.tind.leetcode

/**
 *@author: lonnie.liang
 *date: 2022/05/22 23:35
 *  https://leetcode.cn/problems/game-of-life/
 */
class LeetCode289 {
    fun gameOfLife(board: Array<IntArray>) {
        /**
        如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
        如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
        如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
        如果死细胞周围正好有三个活细胞，则该位置死细胞复活；

        我又来帮大家捋一捋思路了。这题原理没啥复杂，关键就是规则挺麻烦，怎么能捋清规则以及合理设计复合状态呢？且看我来捋一捋。

        一. 普遍意义上，如果规则极其繁复，如何简化这些规则呢？
        关于逻辑表达式的简化可能会用上“卡诺图”，有兴趣的朋友请自行查一查。

        二. 这道题的规则如何简化？
        1. 原来是活的，周围有2-3个活的，成为活的
        2. 原来是死的，周围有3个活的，成为活的
        3. 其他都是死了

        三. 复合状态如何设计？

        说真的，状态稍微多一点，这种用特定的新数字表示新状态的做法容易把自己搞懵，又是2又是-1的，自己的代码隔一天看，自己都捋不顺。

        我咋干的？首先遍历的时候我不让每一个格子都看一眼周围的八个格子去更新自己状态。我换个角度，遍历的时候，如果这个格子里是活的，
        我就让它去“影响”周围的八个格子。这样一来，大批原来是死了的格子就省了很多检查的时间。怎么“影响”？简单，我给被影响的格子里的数字加10。
        这样一来，个位存着这格子原来的状态，十位就存着它周围有多少个活格子了。比如遍历完了之后一个格子里是41，那就表示它原来自己是1，
        然后被周围的四个活格子加了四个10，于是周围有四个活细胞。

        等之后再遍历一遍，更新到最新状态就完事了
         */


        board.forEachIndexed { rowIndex, colArray ->
            colArray.forEachIndexed { colIndex, status ->
                if (status % 10 == 1) {
                    affectOthers(rowIndex, colIndex, board)
                }
            }
        }

        board.forEachIndexed { rowIndex, colArray ->
            colArray.forEachIndexed { colIndex, status ->
                val livedNeighbourCount = status / 10
                val originStatus = status % 10
                if (livedNeighbourCount in setOf(2, 3) && originStatus == 1) {
                    board[rowIndex][colIndex] = 1
                } else if (livedNeighbourCount == 3 && originStatus == 0) {
                    board[rowIndex][colIndex] = 1
                } else {
                    board[rowIndex][colIndex] = 0
                }
            }
        }
    }

    private fun affectOthers(
        rowIndex: Int,
        colIndex: Int,
        board: Array<IntArray>
    ) {
        val rowCount = board.size
        val colCount = board.firstOrNull()?.size ?: 0
        for (neighbourRow in rowIndex - 1..rowIndex + 1) {
            for (neighbourCol in colIndex - 1..colIndex + 1) {
                val isSelf = neighbourRow == rowIndex && neighbourCol == colIndex
                if (neighbourRow in 0 until rowCount && neighbourCol in 0 until colCount && !isSelf) {
                    board[neighbourRow][neighbourCol] += 10
                }
            }
        }
    }

}