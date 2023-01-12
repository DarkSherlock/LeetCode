package com.liang.tind.leetcode.backtrace

import com.liang.tind.leetcode.datastructrue.TreeNode
import org.junit.Test

/**
 * @author: lonnie.liang
 * date: 2022/05/20 23:33
 * https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
class LeetCode106 {

    private val inorderMap = mutableMapOf<Int, Int>()

    @Test
    fun test() {
       val path = ArrayList<Int>()
        path.removeLast()
    }

    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        inorder.forEachIndexed { index, i ->
            inorderMap[i] = index
        }

        return findNode(inorder, 0, inorder.size, postorder, 0, postorder.size)
    }

    private fun findNode(
        inorder: IntArray,
        inorderBegin: Int,
        inorderEnd: Int,
        postorder: IntArray,
        postorderBegin: Int,
        postorderEnd: Int
    ): TreeNode? {
        if (inorderBegin >= inorderEnd || postorderBegin >= postorderEnd) {
            return null
        }

        val rootValue = postorder[postorderEnd - 1]
        val root = TreeNode(rootValue)
        val rootIndex = inorderMap[rootValue] ?: 0
        val leftLength = rootIndex - inorderBegin
        root.left = findNode(
            inorder,
            inorderBegin,
            rootIndex,
            postorder,
            postorderBegin,
            postorderBegin + leftLength
        )

        root.right = findNode(
            inorder,
            rootIndex + 1,
            inorderEnd,
            postorder,
            postorderBegin + leftLength,
            postorderEnd - 1
        )

        return root
    }
}