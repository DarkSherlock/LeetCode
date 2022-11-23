package com.liang.tind.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by sherlock
 * <p>
 * date 2019/12/21
 */
public class TestExample {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer integer = map.get(num);
            if (integer == null) {
                map.put(num, 1);
            } else {
                map.put(num, integer + 1);
            }
        }
        Map.Entry<Integer, Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }

        return maxEntry.getKey();
    }

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 示例:
     * <p>
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     * <p>
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/move-zeroes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        // 双指针： i用来向前探索 j用来记录 <=j 的都不为0；
        int j = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                j++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
    }

    /**
     * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
     * <p>
     * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
     * <p>
     * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * [4,3,2,7,8,2,3,1]
     * <p>
     * 输出:
     * [5,6]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        /**
         * 【笔记】将所有正数作为数组下标，置对应数组值为负值。那么，仍为正数的位置即为（未出现过）消失的数字。
         *
         * 举个例子：
         *
         * 原始数组：[4,3,2,7,8,2,3,1]
         *
         * 重置后为：[-4,-3,-2,-7,8,2,-3,-1]
         *
         * 结论：[8,2] 分别对应的index为[5,6]（消失的数字）
         */
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (nums[Math.abs(num) - 1] > 0) {
                nums[Math.abs(num) - 1] = -nums[Math.abs(num) - 1];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }

        return list;
    }


    /**
     * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
     * <p>
     * 示例:
     * 输入: S = "a1b2"
     * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
     * <p>
     * 输入: S = "3z4"
     * 输出: ["3z4", "3Z4"]
     * <p>
     * 输入: S = "12345"
     * 输出: ["12345"]
     * 注意：
     * <p>
     * S 的长度不超过12。
     * S 仅由数字和字母组成。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/letter-case-permutation
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param S
     * @return
     */
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        dfs(S, 0, "", result);
        return result;
    }

    private void dfs(String S, int index, String pre, List<String> result) {
        if (index == S.length()) {
            result.add(pre);
        } else {
            char c = S.charAt(index);
            if (!Character.isLetter(c)) {
                dfs(S, index + 1, pre + c, result);
            } else {
                char upperCase = Character.toUpperCase(c);
                dfs(S, index + 1, pre + upperCase, result);

                char lowerCase = Character.toLowerCase(c);
                dfs(S, index + 1, pre + lowerCase, result);
            }
        }
    }

    public void sort(int[] nums) {

    }

    private void mergeSort(int low, int high, int[] nums) {
        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;
        mergeSort(low, mid, nums);
        mergeSort(mid + 1, high, nums);
        merge(low, mid, high, nums);
    }

    private void merge(int low, int mid, int high, int[] nums) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (nums[i] >= nums[j]) {
                temp[k++] = nums[j++];
            } else {
                temp[k++] = nums[i++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while ((j <= high)) {
            temp[k++] = nums[j++];
        }

        System.arraycopy(temp, 0, nums, low, temp.length);
    }


    private void revertStringTest() {
        String s = "abcdefg";
        revertString(s, 0);
    }

    private void revertString(String s, int current) {
        if (current + 1 < s.length()) {
            revertString(s, current + 1);
        }
        System.out.println(s.charAt(current));
    }
}
