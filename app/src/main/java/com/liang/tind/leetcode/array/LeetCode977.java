package com.liang.tind.leetcode.array;

/**
 * created by sherlock
 * <p>
 * date 2019/12/29
 * <p>
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode977 {
    public int[] sortedSquares(int[] A) {
        // A是按照升序排序 -5,-2,-1,0,1,2
        //先找出负数区间 和 正数 区间，然后 平方后比较大小合并进去新数组
        int j = 0;
        while (j < A.length && A[j] < 0) {
            j++;
        }
        //i为最后一个负数的索引，j为第一个正数索引
        int i = j - 1;

        int[] result = new int[A.length];
        int t = 0;

        while (i >= 0 && j < A.length) {
            if (A[i] * A[i] > A[j] * A[j]) {
                result[t++] = A[j] * A[j];
            } else {
                result[t++] = A[i] * A[i];
            }
            i--;
            j++;
        }

        while (i >= 0) {
            result[t++] = A[i] * A[i];
            i--;
        }

        while (j < A.length) {
            result[t++] = A[j] * A[j];
            j++;
        }

        return result;
    }
}
