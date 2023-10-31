package com.liang.tind.leetcode.dp

/**
 * @author: lonnie.liang
 * date: 2022/05/20 23:33
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/?favorite=2ckc81c
 */
class LeetCode11 {
    fun maxArea(height: IntArray): Int {
        // https://leetcode.cn/problems/container-with-most-water/solution/container-with-most-water-shuang-zhi-zhen-fa-yi-do/
        // [i, j]的最多面积s = (j-i) * min(height[i], height[j])
        // 无论移动长板还是短板j-i 一定减少1
        // 如果移动短板，min(i,j) 可能变大变小或者不变，s就可能变大
        // 如果移动长板，min(i,j) 可能不变或者变小，s一定变小（因为j-i变小了）
        // 所以下个状态的比较应该移动短板
        var i = 0
        var j = height.size - 1
        var ans = 0
        while(i<j) {
            val temp = if(height[i] < height[j]) {
                (j-i) * height[i++]
            } else {
                (j-i) * height[j--]
            }

            ans = Math.max(ans, temp)
        }

        return ans

    }



}