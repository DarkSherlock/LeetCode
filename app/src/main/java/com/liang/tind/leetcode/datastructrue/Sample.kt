package com.liang.tind.leetcode.datastructrue

/**
 *@author: lonnie.liang
 *date: 2022/05/07 17:42
 * refer to https://blog.csdn.net/weixin_40422192/article/details/124325334
 */
class Sample {

    fun arrayToTree(intArray: IntArray): TreeNode? {
        if (intArray.isEmpty()) return null
        val rootIndex = intArray.size / 2
        val rootNode = TreeNode(intArray[rootIndex])
        arrayToTree(intArray, 0, intArray.size - 1, rootNode, rootIndex)
        return rootNode
    }

    private fun arrayToTree(
        intArray: IntArray,
        left: Int,
        right: Int,
        rootNode: TreeNode,
        root: Int
    ) {
        if (left == right) return

        if (left != root) {
            val leftRootIndex = left + (root - left) / 2
            rootNode.left = TreeNode(intArray[leftRootIndex])
            // 继续将左边切割去构建左子树
            arrayToTree(intArray, left, root - 1, rootNode.left, leftRootIndex)
        }

        if (right != root) {
            val rightRootIndex = root + (right + 1 - root) / 2
            rootNode.right = TreeNode(intArray[rightRootIndex])
            // 继续将右边切割去构建右子树
            arrayToTree(intArray, root + 1, right, rootNode.right, rightRootIndex)
        }
    }

    fun DLR(node: TreeNode?) {
        if (node == null) {
            println("node is null")
            return
        }
        println(node.`val`)
        node.left?.let { DLR(it) }
        node.right?.let { DLR(it) }
    }

    fun LDR(node: TreeNode?) {
        if (node == null) {
            println("node is null")
            return
        }
        node.left?.let { LDR(it) }
        println(node.`val`)
        node.right?.let { LDR(it) }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val sample = Sample()
            var root = sample.arrayToTree(intArrayOf())
            println("遍历空arr")
            sample.LDR(root)

            root = sample.arrayToTree(intArrayOf(0))
            println("遍历空arr.size=1")
            sample.LDR(root)

            root = sample.arrayToTree(intArrayOf(0, 1))
            println("遍历空arr.size=2")
            sample.LDR(root)

            /**
             *     3
             *    / \
             *   1   5
             *  /\   /\
             * 0 2  4 6
             */
            root = sample.arrayToTree(intArrayOf(0, 1, 2, 3, 4, 5, 6))
            println("遍历空arr.size=7")
            sample.LDR(root)

            /**
             *
             */
            root = sample.arrayToTree(intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9))
            println("遍历空arr.size=10")
            sample.LDR(root)
        }
    }
}