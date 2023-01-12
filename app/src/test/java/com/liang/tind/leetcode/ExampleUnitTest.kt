package com.liang.tind.leetcode

import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import com.liang.tind.leetcode.datastructrue.TreeNode
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashSet

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        // 1 2 3 3 4 5

        assertEquals(4, 2 + 2)

    }

    fun mySqrt(x: Int): Int {
        var l = 0
        var r = x
        var ans = -1
        while (l <= r) {
            val mid = l + (r - l) / 2
            if (mid.toLong() * mid <= x) {
                ans = mid
                l = mid + 1
            } else {
                r = mid - 1
            }
        }
        return ans
    }

    @Test
    fun testK() {
        val mat = arrayOf(
            intArrayOf(1, 1, 0, 0, 0),
            intArrayOf(1, 1, 1, 1, 0),
            intArrayOf(1, 0, 0, 0, 0),
            intArrayOf(1, 1, 0, 0, 0),
            intArrayOf(1, 1, 1, 1, 1)
        )
        val k = 3
        kWeakestRows(mat, k)
    }

    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
        val pq = PriorityQueue<Pair<Int, Int>> { o1, o2 ->
            if (o1.second == o2.second) {
                o1.first - o2.first
            } else {
                o1.second - o2.second
            }
        }
        mat.forEachIndexed { index, items ->
            var l = 0
            var r = items.size - 1

            while (l < r) {
                val mid = (l + r + 1) / 2
                if (items[mid] == 0) {
                    r = mid - 1
                } else {
                    l = mid
                }
            }

            val power = if (items[l] == 0) {
                0
            } else {
                l + 1
            }
            println("power=$power,index=$index,l=$l")
            pq.offer(Pair(index, power))
        }

        val res = IntArray(k)
        res.forEachIndexed { index, i ->
            res[index] = pq.poll().first
        }
        return res
    }

    @Test
    fun test() {
        val set = LinkedHashSet<Int>()
        repeat(10) {
            set.add(it)
        }
        println(set.joinToString())
        val removeFirst = set.removeFirst()
        println("$removeFirst")
        println(set.joinToString())

        val removeFirst1 = set.removeFirst()
        println("$removeFirst1")
        println(set.joinToString())
    }

    fun <T> LinkedHashSet<T>.removeFirst(): T? {
        this.iterator().let { i ->
            if (i.hasNext()) {
                i.next().let {
                    i.remove()
                    return it
                }
            } else {
                return null
            }
        }
    }


    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val res = IntArray(nums1.size) { -1 }
        val map = HashMap<Int, Int>()
        val stack = LinkedList<Int>()
        nums2.forEachIndexed { index, num2 ->
            while (stack.isNotEmpty() && stack.peek() <= num2) {
                val pre = stack.pop()
                map[pre] = num2
            }
            stack.push(num2)
        }
        nums1.forEachIndexed { index, num1 ->
            res[index] = map.getOrDefault(num1, -1)
        }
        return res
    }


    fun threeSum(nums: IntArray): List<List<Int>> {
        //https://programmercarl.com/0015.%E4%B8%89%E6%95%B0%E4%B9%8B%E5%92%8C.html#%E5%85%B6%E4%BB%96%E8%AF%AD%E8%A8%80%E7%89%88%E6%9C%AC
        val res = mutableListOf<List<Int>>()
        Arrays.sort(nums)

        nums.forEachIndexed { index, i ->
            if (i > 0) return res
            if (index > 0 && nums[index - 1] == i) {
                return@forEachIndexed
            }
            var left = index + 1
            var right = nums.lastIndex
            while (left < right) {
                val sum = i + nums[left] + nums[right]
                if (sum == 0) {
                    res.add(arrayListOf(i, nums[left], nums[right]))
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--
                    }
                    right--
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++
                    }
                    left++
                } else if (sum < 0) {
                    left++
                } else {
                    right--
                }
            }
        }

        return res
    }

    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        Arrays.sort(nums)
        for (i in nums.indices) {
            if (nums[i] > 0 && nums[i] > target) return res
            if (i > 0 && nums[i] == nums[i - 1]) continue

            for (j in i + 1 until nums.size) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue

                var left = j + 1
                var right = nums.lastIndex
                while (left < right) {
                    val sum = nums[i] + nums[j] + nums[left] + nums[right]
                    if (sum == target) {
                        res.add(arrayListOf(nums[i], nums[j], nums[left], nums[right]))
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--
                        }
                        right--
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++
                        }
                        left++
                    } else if (sum > target) {
                        right--
                    } else {
                        left++
                    }
                }
            }
        }

        return res
    }
}
