package com.liang.tind.leetcode.backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * created by sherlock
 * <p>
 * date 2019/12/22
 * 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
 * <p>
 * 示例 1：
 * 输入："AAB"
 * 输出：8
 * 解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
 * <p>
 * 示例 2：
 * 输入："AAABBC"
 * 输出：188
 * <p>
 * 提示：
 * <p>
 * 1 <= tiles.length <= 7
 * tiles 由大写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-tile-possibilities
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode1079 {
    public static void main(String[] args) {
        numTilePossibilities("AAB");
    }

    /**
     * 结束条件是 cur== nums.length;
     * 路径：tacks
     * <p>
     * dfs()
     */
    public static int numTilePossibilities(String tiles) {
        Set<String> res = new HashSet<>();
        boolean[] visited = new boolean[tiles.length()];
        dfs(tiles, visited, new StringBuilder(), res);
        return res.size() - 1;
    }

    private static void dfs(String tiles, boolean[] visited, StringBuilder tracks, Set<String> res) {
        res.add(tracks.toString());
        if (tracks.length() == tiles.length()) return;
        for (int i = 0; i < tiles.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                tracks.append(tiles.charAt(i));
                dfs(tiles, visited, tracks, res);
                tracks.deleteCharAt(tracks.length() - 1);
                visited[i] = false;
            }
        }
    }


}
