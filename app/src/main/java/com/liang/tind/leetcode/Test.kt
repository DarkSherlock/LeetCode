package com.liang.tind.leetcode

import com.liang.tind.leetcode.datastructrue.BTree

/**
 * created by sherlock
 *
 *
 * date 2019/12/14
 */
class Test {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val bTree = BTree<Int, Int>()
            bTree.put(60, 60)
            bTree.put(11, 11)
            bTree.put(21, 21)
            bTree.put(17, 17)
            bTree.put(7, 7)
            bTree.put(3, 3)
            bTree.put(78, 78)
            bTree.put(45, 45)

            println(bTree.min())
            println(bTree.max())
        }
    }


}