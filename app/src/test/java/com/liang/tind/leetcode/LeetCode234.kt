package com.liang.tind.leetcode

import com.liang.tind.leetcode.datastructrue.ListNode

/**
 * @author: lonnie.liang
 * date: 2022/05/20 23:33
 * https://leetcode.cn/problems/palindrome-linked-list/
 */
class LeetCode234 {

    fun isPalindrome(head: ListNode?): Boolean {
        // 1 2 2 1
        // 1 2 3 2 1
        // 快慢指针同时出发，快指针到链尾时，slow到达中点，如果fast!=null证明时case2 链表是奇数，此时slow要再进一位
        // 慢指针前进的时候顺便把前半部分反转
        // 然后从中间开始 比较
        // 比较的时候再恢复前半部分
        if (head == null) return true
        var slow: ListNode? = head
        var fast: ListNode? = head
        var pre: ListNode? = null
        while (fast != null && fast.next != null) {
            fast = fast.next.next
            val temp = slow?.next
            slow?.next = pre
            pre = slow
            slow = temp
        }
        var cur = pre
        pre = slow
        if (fast != null) slow = slow?.next
        var isPalindrome = true
        while (slow != null) {
            if (slow.`val` != cur?.`val`) {
                isPalindrome = false
            }
            val temp = cur?.next
            cur?.next = pre
            pre = cur
            cur = temp
            slow = slow?.next
        }
        return isPalindrome
    }

}