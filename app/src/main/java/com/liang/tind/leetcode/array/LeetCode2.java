package com.liang.tind.leetcode.array;

/**
 * created by sherlock
 * <p>
 * date 2019/12/23
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class LeetCode2 {

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        twoSum(numbers, 9);
    }

    public static int[] twoSum(int[] numbers, int target) {
//        for (int i = 0; i < numbers.length - 1; i++) {
//            for (int j = i + 1; j < numbers.length; j++) {
//                if (numbers[i] + numbers[j] == target) {
//                    return new int[]{i + 1, j + 1};
//                }
//            }
//        }

        // [2, 7, 11, 15]
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < numbers.length; i++) {
//            if (map.containsKey(target - numbers[i])) {
//                return new int[]{ map.get(target - numbers[i])+ 1, i + 1};
//            }else {
//                map.put(numbers[i],i);
//            }
//        }

        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            if (numbers[low] + numbers[high] > target) {
                high--;
            } else if (numbers[low] + numbers[high] < target) {
                low++;
            } else {
                return new int[]{low + 1, high + 1};
            }
        }

        return null;
    }
}
