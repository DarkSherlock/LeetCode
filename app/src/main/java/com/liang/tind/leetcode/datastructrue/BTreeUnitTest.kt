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
            println("max depth:${bTree.maxDepth}")
            println("min depth:${bTree.minDepth}")

            println("前序遍历：")
            bTree.DLR()
            println("非递归前序遍历：")
            bTree.DLR2()
            println("非递归前序遍历 统一写法：")
            bTree.DLR3()

            println("中序遍历：")
            bTree.LDR()
            println("非递归中序遍历：")
            bTree.LDR2()
            println("非递归中序遍历 统一写法：")
            bTree.LDR3()

            println("后序遍历：")
            bTree.LRD()
            println("非递归后序遍历 统一写法：")
            bTree.LRD3()

            println("层序遍历 广度优先搜索：")
            bTree.BFS()

            println("层序遍历 广度优先搜索 递归方式：")
            bTree.BFS2()

            bTree.remove(11)
            bTree.remove(12)
            /**
             *           60
             *         /   \
             *       21    78
             *      / \    /
             *     17 25  65
             *    /
             *   7
             *  / \
             * 3   8
             */
            println("after remove 11 层序遍历 广度优先搜索 递归方式：")
            bTree.BFS2()

            bTree.remove2(21)
            /**
             *           60
             *         /   \
             *       25    78
             *      /     /
             *     17    65
             *    /
             *   7
             *  / \
             * 3   8
             */
            println("after remove21, 层序遍历 广度优先搜索 递归方式：")
            bTree.BFS2()
        }
    }

    
}