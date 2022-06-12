package com.liang.tind.leetcode

import com.liang.tind.leetcode.datastructrue.ListNode


/**
 *@author: lonnie.liang
 *date: 2022/05/22 23:35
 *  https://leetcode.cn/problems/merge-two-sorted-lists/
 */
class LeetCode21 {

    private fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val preHead = ListNode(-1)
        var preNode: ListNode? = preHead
        var node1 = list1
        var node2 = list2
        while (node1 != null && node2 != null) {
            if (node1.`val` > node2.`val`) {
                preNode?.next = node2
                node2 = node2.next
            } else {
                preNode?.next = node1
                node1 = node1.next
            }

            preNode = preNode?.next
        }
        preNode?.next = node1 ?: node2
        return preHead.next
    }
}