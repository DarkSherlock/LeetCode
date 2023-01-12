package com.liang.tind.leetcode.backtrace

import com.liang.tind.leetcode.datastructrue.TreeNode
import org.junit.Test

/**
 * @author: lonnie.liang
 * date: 2022/05/20 23:33
 * https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * https://programmercarl.com/0654.%E6%9C%80%E5%A4%A7%E4%BA%8C%E5%8F%89%E6%A0%91.html#%E8%A7%86%E9%A2%91%E8%AE%B2%E8%A7%A3
 */
class LeetCode236 {
    @Test
    fun test() {

    }

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        //solution1:递归
        // 采用后续遍历 因为后续遍历是自底向上的，所以我们只要判断一个节点的左右节点包含p and q那么它就是公共祖先，如果只有左节点包含
        //那么祖先在左子树，右子树同理

        return solution1(root, p, q)
        // solution2: 记录父节点。map记录当前节点对应的父节点，然后从Q向上搜索PATH记录下来。再去向上搜索Q，如果遇到PATH有的则是共同祖先
//        return solution2(root, p, q)
    }

    private fun solution1(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || root == p || root == q) return root

        val left = solution1(root.left, p, q)
        val right = solution1(root.right, p, q)
        return if (left != null && right != null) {
            root
        } else if (left == null && right != null) {
            right
        } else if (left != null && right == null) {
            left
        } else {
            null
        }
    }

    private fun solution2(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        val parentMap = mutableMapOf<Int, TreeNode>()
        val visited = mutableSetOf<Int>()
        LDR(root, parentMap)

        var pNode: TreeNode? = p
        while (pNode != null) {
            visited.add(pNode.`val`)
            pNode = parentMap[pNode.`val`]
        }

        var qNode = q
        while (qNode != null) {
            if (visited.contains(qNode.`val`)) {
                return qNode
            }
            qNode = parentMap[qNode.`val`]
        }

        return null
    }

    private fun LDR(node: TreeNode?, parentMap: MutableMap<Int, TreeNode>) {
        if (node == null) return
        node.left?.let {
            parentMap[it.`val`] = node
            LDR(it, parentMap)
        }
        node.right?.let {
            parentMap[it.`val`] = node
            LDR(it, parentMap)
        }
    }
}