package com.liang.tind.leetcode

/**
 * @author: lonnie.liang
 * date: 2022/05/20 23:33
 * https://leetcode.cn/problems/sort-colors/
 */
class LeetCode75 {

    fun sortColors(nums: IntArray): Unit {
        // https://leetcode.cn/problems/sort-colors/solution/yan-se-fen-lei-by-leetcode-solution/
//        solution1(nums)
        solution2(nums)
    }

    private fun solution1(nums: IntArray) {
        // 两次遍历，第一次把0排在前面， 第二次把1排在0后面
        var index = 0
        for (i in nums.indices) {
            if (nums[i] == 0) {
                val temp = nums[index]
                nums[index] = nums[i]
                nums[i] = temp
                index++
            }
        }

        for (i in index until nums.size) {
            if (nums[i] == 1) {
                val temp = nums[index]
                nums[index] = nums[i]
                nums[i] = temp
                index++
            }
        }
    }

    private fun solution2(nums: IntArray) {
        // 用2个指针，p0, p2，如果找到了0，就和p0交换，如果找到了1就continue，找到了2，就和p2交换，
        // 但是和p2交换过后新的num[i] 可能是2还可能是0所以这时候需要继续判断（因为是从左向右遍历的，p2的位置还未排序
        // 过，p0交换的时候前面都已经排序过了所以不需要再判断）
        var i = 0
        var p0 = 0
        var p2 = nums.size - 1
        while (i <= p2) {
            if (nums[i] == 0) {
                nums.swap(p0, i)
                i++
                p0++
            } else if (nums[i] == 1) {
                i++
            } else {
                nums.swap(p2, i)
                p2--
            }
        }
    }

    private fun IntArray.swap(i1: Int, i2: Int) {
        val temp = this[i1]
        this[i1] = this[i2]
        this[i2] = temp
    }
}