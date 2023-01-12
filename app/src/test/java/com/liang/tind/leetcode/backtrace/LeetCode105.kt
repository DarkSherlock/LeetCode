package com.liang.tind.leetcode.backtrace

import com.liang.tind.leetcode.datastructrue.TreeNode
import org.junit.Test

/**
 * @author: lonnie.liang
 * date: 2022/05/20 23:33
 *  https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *  https://programmercarl.com/0106.%E4%BB%8E%E4%B8%AD%E5%BA%8F%E4%B8%8E%E5%90%8E%E5%BA%8F%E9%81%8D%E5%8E%86%E5%BA%8F%E5%88%97%E6%9E%84%E9%80%A0%E4%BA%8C%E5%8F%89%E6%A0%91.html#%E6%80%9D%E8%B7%AF
 */
class LeetCode105 {


    @Test
    fun test() {

    }

    private val inorderMap = mutableMapOf<Int, Int>()

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        inorder.forEachIndexed { index, i ->
            inorderMap[i] = index
        }

        return findNode(inorder, 0, inorder.size, preorder, 0, preorder.size)
    }

    private fun findNode(
        inorder: IntArray,
        inorderBegin: Int,
        inorderEnd: Int,
        preorder: IntArray,
        preorderBegin: Int,
        preorderEnd: Int
    ): TreeNode? {
        if (inorderBegin >= inorderEnd || preorderBegin >= preorderEnd) {
            return null
        }

        val rootValue = preorder[preorderBegin]
        val root = TreeNode(rootValue)
        val rootIndex = inorderMap[rootValue] ?: 0
        val leftLength = rootIndex - inorderBegin
        root.left = findNode(
            inorder,
            inorderBegin,
            rootIndex,
            preorder,
            preorderBegin + 1,
            preorderBegin + 1 + leftLength
        )

        root.right = findNode(
            inorder,
            rootIndex + 1,
            inorderEnd,
            preorder,
            preorderBegin + leftLength + 1,
            preorderEnd
        )

        return root
    }
}