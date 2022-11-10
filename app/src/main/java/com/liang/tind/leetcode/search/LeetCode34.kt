package com.liang.tind.leetcode.search

/**
 *@author: lonnie.liang
 *date: 2022/05/26 22:10
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 * 你必须设计并实现时间复杂度为O(log n)的算法解决此问题。
 * nums = [5,7,7,8,8,10], target = 8 => [3,4]
 * nums = [5,7,7,8,8,10], target = 6 => [-1,-1]
 * nums = [], target = 0 => [-1,-1]
 */
class LeetCode34 {

    fun searchRange(nums: IntArray, target: Int): IntArray {
        val leftIdx = binarySearchLeft(nums, target)
        val rightIdx = binarySearchRight(nums, target) - 1
        return if (leftIdx <= rightIdx && rightIdx < nums.size && nums[leftIdx] == target && nums[rightIdx] == target) {
            intArrayOf(leftIdx, rightIdx)
        } else intArrayOf(-1, -1)
    }

    private fun binarySearchLeft(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        var ans = nums.size
        while (left <= right) {
            val mid = (left + right) / 2
            if (nums[mid] >= target) {
                right = mid - 1
                ans = mid
            } else {
                left = mid + 1
            }
        }
        return ans
    }

    private fun binarySearchRight(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        var ans = nums.size
        while (left <= right) {
            val mid = (left + right) / 2
            if (nums[mid] > target) {
                right = mid - 1
                ans = mid
            } else {
                left = mid + 1
            }
        }
        return ans
    }


    // solution2
    fun searchRange2(nums: IntArray, target: Int): IntArray? {
        val index = BinarySearch.binarySearch(nums, target) // 二分查找
        if (index == -1) { // nums 中不存在 target，直接返回 {-1, -1}
            return intArrayOf(-1, -1) // 匿名数组
        }
        // nums 中存在 targe，则左右滑动指针，来找到符合题意的区间
        var left = index
        var right = index
        // 向左滑动，找左边界
        while (left - 1 >= 0 && nums[left - 1] == nums[index]) { // 防止数组越界。逻辑短路，两个条件顺序不能换
            left--
        }
        // 向左滑动，找右边界
        while (right + 1 < nums.size && nums[right + 1] == nums[index]) { // 防止数组越界。
            right++
        }
        return intArrayOf(left, right)
    }

}