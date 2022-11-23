package com.liang.tind.leetcode.datastructrue

/**
 *@author: lonnie.liang
 *date: 2022/06/19 22:44
 *   https://leetcode.cn/problems/kth-smallest-element-in-a-bst/
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）
 *
 *    3
 *  1   4
 *   2
 * 输入：root = [3,1,4,null,2], k = 1
 *   输出：1
 */
class LeetCode230 {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        //计算每个节点的作为跟节点的子树的节点树
        // 如果node 左子树的节点数left<k-1 那么k在右子树令node=node.right ,k=k-1-left
        // 如果node 左子树的节点数left=k-1， k就是node
        // 如果node 左子树的节点数left>k-1， 令node = node.left 继续搜索
        if (root == null) return 0

        val myTree = MyTree(root)
        return myTree.kthSmallest(k)
    }

    class MyTree(private val root: TreeNode) {
        private val nodeMap = mutableMapOf<TreeNode?, Int>()

        init {
            countNodeNum(root)
        }

        private fun countNodeNum(node: TreeNode?): Int {
            if (node == null) return 0

            val num = countNodeNum(node.left) + countNodeNum(node.right) + 1
            nodeMap[node] = num
            return num
        }

        internal fun kthSmallest(k: Int): Int {
            var node: TreeNode? = root
            var targetK = k
            while (node != null) {
                val left = nodeMap.getOrDefault(node.left, 0)
                if (left < targetK - 1) {
                    node = node.right
                    targetK = targetK - 1 - left
                } else if (left == targetK - 1) {
                    break
                } else {
                    node = node.left
                }
            }

            return node?.`val` ?: 0
        }
    }
}