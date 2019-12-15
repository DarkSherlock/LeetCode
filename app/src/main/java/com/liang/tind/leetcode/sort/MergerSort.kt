package com.liang.tind.leetcode.sort

/**
 *created by sherlock
 *
 *date 2019/12/10
 *
 * @see https://www.cxyxiaowu.com/2176.html
 */
class MergerSort : Sort() {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            mergeSort(arr)
            println(arr.joinToString())
        }

        fun mergeSort(arr: IntArray) {
            realMergeSort(0, arr.size - 1, arr)
        }

        fun realMergeSort(low: Int, high: Int, arr: IntArray) {
            if (arr.isEmpty() || low >= high){
                return
            }
            val mid = (low + high) / 2
            realMergeSort(low, mid, arr)
            realMergeSort(mid + 1, high, arr)
            merge(low, mid, high, arr)
        }

        fun merge(low: Int, mid: Int, high: Int, arr: IntArray) {
            var i = low
            var j = mid + 1
            var k = 0
            val temp = IntArray(high - low + 1)
            while (i <= mid && j <= high) {
                if (arr[i] >= arr[j]) {
                    temp[k++] = arr[j++]
                } else {
                    temp[k++] = arr[i++]
                }
            }

            while (i <= mid) {
                temp[k++] = arr[i++]
            }

            while (j <= high) {
                temp[k++] = arr[j++]
            }
            System.arraycopy(temp, 0, arr, low, temp.size)
        }

    }
}