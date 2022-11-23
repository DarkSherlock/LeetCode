package com.liang.tind.leetcode.dp

import com.liang.tind.leetcode.datastructrue.ListNode
import org.junit.Assert.*
import org.junit.Test

/**
 * @author: lonnie.liang
 * date: 2022/06/04 17:40
 */
class LeetCode328Test {

    @Test
    fun test() {
        val sample = LeetCode328()

        var node  = ListNode(1)
        val head = node
        for (i in 2 .. 5) {
            val next = ListNode(i)
            node.next = next
            node = next
        }

        var answer = sample.oddEvenList(head)

        while (answer!=null) {
            println(answer.`val`)
            answer = answer.next
        }
    }
}