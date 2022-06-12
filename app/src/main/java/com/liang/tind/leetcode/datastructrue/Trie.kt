package com.liang.tind.leetcode.datastructrue

import org.w3c.dom.Node

/**
 *@author: lonnie.liang
 *date: 2022/06/05 17:31
 * https://leetcode.cn/problems/implement-trie-prefix-tree/
 */
class Trie {
    private val children = arrayOfNulls<Trie?>(26)
    private var isEnd = false

    fun insert(word: String) {
        var node = this
        word.forEach { c ->
            val index = c - 'a'
            if (node.children[index] == null) {
                node.children[index] = Trie()
            }
            node = node.children[index]!!
        }
        isEnd = true
    }

    fun search(word: String): Boolean {
        val node = searchPrefix(word)
        return node != null && node.isEnd
    }

    fun startsWith(prefix: String): Boolean {
        return searchPrefix(prefix) != null
    }

    private fun searchPrefix(prefix: String): Trie? {
        var node = this
        prefix.forEach { c ->
            val index = c - 'a'
            if (node.children[index] == null) {
                return null
            }

            node = node.children[index]!!
        }

        return node
    }

}