package com.liang.tind.leetcode.backtrace

import com.liang.tind.leetcode.datastructrue.TreeNode
import org.junit.Test

/**
 * @author: lonnie.liang
 * date: 2022/05/20 23:33
 * https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * https://programmercarl.com/0654.%E6%9C%80%E5%A4%A7%E4%BA%8C%E5%8F%89%E6%A0%91.html#%E8%A7%86%E9%A2%91%E8%AE%B2%E8%A7%A3
 */
class LeetCode654 {


    @Test
    fun test() {

    }

    fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
        return findNode(nums, 0, nums.size)
    }


    private fun findNode(
        nums: IntArray,
        begin: Int,
        end: Int,
    ): TreeNode? {
        if (begin >= end) {
            return null
        }

        if (end - begin == 1) {// 只有一个元素
            return TreeNode(nums[begin])
        }

        var max = nums[begin]
        var index = begin
        for (i in begin + 1 until end) {
            if (nums[i] > max) {
                max = nums[i]
                index = i
            }
        }

        val root = TreeNode(max)

        root.left = findNode(
            nums,
            begin,
            index
        )

        root.right = findNode(
            nums,
            index + 1,
            end
        )

        return root
    }

    var maxNode: TreeNode? = null
    fun isValidBST(root: TreeNode?): Boolean {
        //          5
        //     1           4
        //  null null   3     6
        if (root == null) return false

        val leftFlag = if (root.left != null) {
            isValidBST(root.left)
        } else {
            true
        }

        val max = maxNode
        maxNode = if (max == null) {
            root
        } else {
            if (max.`val` >= root.`val`) {
                return false
            } else {
                root
            }
        }

        val rightFlag = if (root.right != null) {
            isValidBST(root.right)
        } else {
            true
        }

        return leftFlag && rightFlag
    }
}