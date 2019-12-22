package com.liang.tind.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * created by sherlock
 * <p>
 * date 2019/12/22
 * <p>
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode78 {

    /**
     * 结束条件是 cur== nums.length;
     * 路径：tacks
     * <p>
     * dfs()
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, nums, new ArrayList<Integer>(), res);
        return res;
    }

    private void dfs(int cur, int[] nums, List<Integer> tracks, List<List<Integer>> res) {
        /**
         *
         *[[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]
         */
        res.add(new ArrayList<Integer>(tracks));
        for (int i = cur; i < nums.length; i++) {
            tracks.add(nums[i]);
            dfs(i+1, nums, tracks, res);
            tracks.remove(tracks.size() - 1);
        }
    }

}
