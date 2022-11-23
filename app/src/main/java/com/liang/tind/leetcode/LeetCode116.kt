package com.liang.tind.leetcode

import com.liang.tind.leetcode.datastructrue.TreeNode
import java.util.*


/**
 *@author: lonnie.liang
 *date: 2022/05/22 23:35
 *  https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
 */
class LeetCode116 {


    private fun connect(root: Node?): Node? {
        if (root == null) return null
        val queue = LinkedList<Node>()
        queue.offer(root)
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val node = queue.poll()
                if (i < size - 1) {
                    node.next = queue.peek()
                }

                if (node.left != null) {
                    queue.offer(node.left)
                }

                if (node.right != null) {
                    queue.offer(node.right)
                }
            }
        }
        return root
    }


    private class Node(var `val`: Int) {
        var left: Node? = null
        var right: Node? = null
        var next: Node? = null
    }

    private fun BFS(node: Node?): Node? {
        if (node == null) return null
        val queue = LinkedList<Node>()
        queue.offer(node)
        while (queue.isNotEmpty()) {
            val cur = queue.poll()
            println(cur.`val`)
            if (cur.left != null) {
                queue.offer(cur.left)
            }

            if (cur.right != null) {
                queue.offer(cur.right)
            }
        }

        return node
    }

}