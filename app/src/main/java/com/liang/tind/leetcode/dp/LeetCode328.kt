package com.liang.tind.leetcode.dp

import com.liang.tind.leetcode.datastructrue.ListNode
import java.util.*

/**
 *
 * https://leetcode.cn/problems/odd-even-linked-list/
 */
class LeetCode328 {

    fun oddEvenList(head: ListNode?): ListNode? {
        // 奇节点
        var odd = head
        val evenHead = odd?.next
        // 偶节点
        var even = evenHead
        //全部节点分离完毕的条件是 even 为空节点或者 even.next 为空节点，此时 odd 指向最后一个奇数节点（即奇数链表的最后一个节点）。
        // even 为空节点： 对应原链表最后一个节点是even，even.next 为空节点对应最后一个是odd
        while (even?.next != null) {
            odd?.next = even.next
            odd = odd?.next
            even.next = odd?.next
            even = even.next
        }

        odd?.next = evenHead
        return head
    }



}