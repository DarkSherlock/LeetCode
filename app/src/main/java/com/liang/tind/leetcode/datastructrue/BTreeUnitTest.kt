package com.liang.tind.leetcode.datastructrue

/**
 *@author: lonnie.liang
 *date: 2022/05/07 11:28
 *
 */
class BTreeUnitTest {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val bTree = BTree<Int, Int>()
            /**
             *        60
             *       / \
             *     11   78
             *    / \   /
             *   7  21 65
             *  /\ / \
             * 3 8 17 25
             *
             */
            bTree.put(60, 60)
            bTree.put(11, 11)
            bTree.put(21, 21)
            bTree.put(17, 17)
            bTree.put(7, 7)
            bTree.put(3, 3)
            bTree.put(78, 78)
            bTree.put(65, 65)
            bTree.put(8, 8)
            bTree.put(25, 25)

            println("min:${bTree.min()}")
            println("max:${bTree.max()}")
            println("depth:${bTree.depth}")

            println("前序遍历：")
            bTree.DLR()

            println("中序遍历：")
            bTree.LDR()

            println("后序遍历：")
            bTree.LRD()

            println("广度优先遍历：")
            bTree.BFS()
        }
    }
}