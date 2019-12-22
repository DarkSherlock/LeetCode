package com.liang.tind.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * created by sherlock
 * <p>
 * date 2019/12/22
 * <p>
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, nums, new LinkedList<Integer>(), res);
        return res;
    }

    private void dfs(int cur, int[] nums, LinkedList<Integer> tracks, List<List<Integer>> res) {
        if (cur == nums.length) {
            res.add(new ArrayList<>(tracks));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tracks.contains(nums[i])) continue;
                tracks.add(nums[i]);
                dfs(cur + 1, nums, tracks, res);
                tracks.removeLast();
            }
        }
    }

}
