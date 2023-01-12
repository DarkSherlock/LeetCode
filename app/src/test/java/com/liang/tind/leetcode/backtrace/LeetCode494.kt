package com.liang.tind.leetcode.backtrace

import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import org.junit.Assert
import org.junit.Test
import java.util.*
import kotlin.collections.ArrayList

/**
 * @author: lonnie.liang
 * date: 2022/05/20 23:33
 *https://leetcode.cn/problems/target-sum/
 */
class LeetCode494 {

    @Test
    fun test() {

    }

    private var count = 0

    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        count = 0
        backtracking(nums, 0, target, 0)
        return count
    }

    private fun backtracking(nums: IntArray, cur: Int, target: Int, sum: Int) {
        if (cur == nums.size) {
            if (target == sum) count++
            return
        }
        backtracking(nums, cur + 1, target, sum + nums[cur])
        backtracking(nums, cur + 1, target, sum - nums[cur])
    }

    private fun packageSolution(nums: IntArray, target: Int):Int {
        //https://programmercarl.com/0494.%E7%9B%AE%E6%A0%87%E5%92%8C.html#%E6%80%9D%E8%B7%AF
        //假设加法总和是x,减法总和即为sum-x
        // target = x - (sum-x)  -> x = (target + sum) / 2
        //问题转化为求bagSize=x的时候有多少种组合.如果(target + sum)无法被平分即无解。
        val sum = nums.sum()
        if (sum < Math.abs(target)) return 0
        if ((target + sum) % 2 != 0 ) return 0
        val bagSize = (target + sum) / 2
        //dp[j] 为当bagSize为j的时候有多少种组合使目标和=j
        // dp[j] = dp[j] + dp[j-i],
        // i=1, dp[4] = dp[4] + dp[3]+ 1 即dp[4]= dp[3] 的方案再加上i=1这一种情况
        // i=2, dp[4] = dp[4] + dp[2]+ 1 累加上次结果。
        // 地推公式为dp[j] += dp[j-i], base case dp[0]=1,即 dp[4] = dp[4-4] = 1,即当i=bagSize 时 这时候直接选i所以方案只有1种
        val dp = IntArray(bagSize + 1)
        dp[0] = 1
        for (i in nums) {
            var j = bagSize
            while (j >= i) {
                dp[j] += dp[j-i]
                j--
            }
        }

        return dp[bagSize]
    }
}