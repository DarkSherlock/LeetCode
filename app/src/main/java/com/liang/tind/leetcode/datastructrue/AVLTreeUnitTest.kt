package com.liang.tind.leetcode.datastructrue

import com.liang.tind.leetcode.datastructrue.AVLTree.AVLNode

/**
 *@author: lonnie.liang
 *date: 2022/05/07 23:03
 *
 */
class AVLTreeUnitTest {
    companion object {
        /**
         * 平衡二叉树
         * 1.左旋
         * 2，右旋
         * 3.双旋
         * @author BayMax
         */
        @JvmStatic
        fun main(args: Array<String>) {
            val avlt = AVLTree(null)
            val arr = intArrayOf(10, 7, 11, 6, 8, 9)
            //循环添加结点到二叉排序树
            for (tmp in arr) {
                avlt.add(AVLNode(tmp))
            }
            //中序遍历
            avlt.infixOrder()

            //测试结点的高度
            println(avlt.root.toString() + "\t" + avlt.height)
            for (tmp in arr) {
                println(tmp.toString() + "  " + avlt.search(tmp)?.height)
            }
        }
    }
}