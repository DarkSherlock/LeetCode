package com.liang.tind.leetcode

/**
 * created by sherlock
 *
 *
 * date 2019/12/14
 */
class Test {
    private fun getIndex(arr: IntArray, low: Int, high: Int): Int {
        var low = low
        var high = high
        val temp = arr[low]
        while (low < high) {
            while (low < high && arr[high] >= temp) {
                high--
            }
            arr[low] = arr[high]
            while (low < high && arr[low] <= temp) {
                low++
            }
            arr[high] = arr[low]
        }
        arr[low] = temp
        return low
    }
}