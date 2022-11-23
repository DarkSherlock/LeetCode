package com.liang.tind.leetcode.search

/**
 *@author: lonnie.liang
 *date: 2022/05/26 22:10
 * https://leetcode.cn/problems/search-insert-position/
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *  nums = [1,3,5,6], target = 5 输出2
 *  nums = [1,3,5,6], target = 2 输出1
 */
class LeetCode35 {

    fun searchInsert(nums: IntArray, target: Int): Int {
        // 当target在nums中返回的是等于nums[mid]的index， 不在的时候返回第一个大于nums[mid]的 index
        var right = nums.size - 1
        var left = 0
        var ans = right + 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (target <= nums[mid]) {
                ans = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return ans
    }
}