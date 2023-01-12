package com.liang.tind.leetcode.backtrace

import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import org.junit.Assert
import org.junit.Test
import java.util.*
import kotlin.collections.ArrayList

/**
 * @author: lonnie.liang
 * date: 2022/05/20 23:33
 * https://leetcode.cn/problems/permutations/
 */
class LeetCode46 {

    @Test
    fun test() {

    }

    private val res = mutableListOf<List<Int>>()

    fun permute(nums: IntArray): List<List<Int>> {
        //给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
        //输入：nums = [1,2,3]
        //输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

        //输入：nums = [0,1]
        //输出：[[0,1],[1,0]]

        //输入：nums = [1]
        //输出：[[1]]
        res.clear()
        backtracking(nums, LinkedList<Int>())
        return res
    }

    private fun backtracking(nums: IntArray, path: MutableList<Int>) {
        if (path.size == nums.size) {
            res.add(kotlin.collections.ArrayList<Int>(path))
            return
        }
        for (i in nums) {
            if (path.contains(i)) continue
            path.add(i)
            backtracking(nums, path)
            path.removeAt(path.lastIndex)
        }
    }
}