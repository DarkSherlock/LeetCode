package com.liang.tind.leetcode.backtrace

import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import org.junit.Assert
import org.junit.Test
import java.util.*
import kotlin.collections.ArrayList

/**
 * @author: lonnie.liang
 * date: 2022/05/20 23:33
 * https://leetcode.cn/problems/permutations-ii/
 */
class LeetCode47 {

    @Test
    fun test() {

    }

    private val res = mutableListOf<List<Int>>()

    fun permuteUnique(nums: IntArray): List<List<Int>> {
        // 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。

        // 输入：nums = [1,1,2]
        // 输出：
        //      [[1,1,2],
        //      [1,2,1],
        //      [2,1,1]]

        //https://leetcode.cn/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
        res.clear()
        Arrays.sort(nums)
        val used = BooleanArray(nums.size)
        backtracking(nums, used, LinkedList<Int>())
        return res
    }

    private fun backtracking(nums: IntArray, used: BooleanArray, path: MutableList<Int>) {
        if (path.size == nums.size) {
            res.add(kotlin.collections.ArrayList<Int>(path))
            return
        }
        for (i in nums.indices) {
            if (used[i]) continue

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue
            used[i] = true
            path.add(nums[i])
            backtracking(nums, used, path)
            path.removeAt(path.lastIndex)
            used[i] = false
        }
    }
}