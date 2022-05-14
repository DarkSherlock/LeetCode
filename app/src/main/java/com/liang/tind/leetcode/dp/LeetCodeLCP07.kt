package com.liang.tind.leetcode.dp

/**
 *
 * 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
 *
 * 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
 * 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
 * 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
 * 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
 *
 * 示例 1：
 *
 * 输入：n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3
 *
 * 输出：3
 * 解释：信息从小 A 编号 0 处开始，经 3 轮传递，到达编号 4。共有 3 种方案，分别是 0->2->0->4， 0->2->1->4， 0->2->3->4。
 *
 */
class LeetCodeLCP07 {

    fun numWays(n: Int, relations: Array<IntArray>, k: Int): Int {
        // 定义数组dp[i][j] 为第i轮能到编号为j的方案数，i in[0,k], j in[0,n), 当i=0时，消息在第1个玩家身上
        // base case: dp[0][j]= 1, j=0 因为从0号玩家开始传递第一轮传到编号为0的玩家的方案数为1
        // base case: dp[0][j]= 0, j!=0 第一轮传到其他玩家的方案数为0
        // 消息[src,dst]如果第i轮能到编号src玩家，则第i+1轮的就能到dst玩家 所以d[i+1][dst] = 第i轮能到src的次数的总和
        // dp[i + 1][dst] += dp[i][src]


        val dp = Array(k + 1) {
            IntArray(n)
        }
        dp[0][0] = 1
        for (i in 0 until k) {
            relations.forEach { relation ->
                val src = relation[0]
                val dst = relation[1]
                dp[i + 1][dst] += dp[i][src]
            }
        }
        return dp[k][n - 1]

        //上述实现的空间复杂度是 O(kn)O(kn)。由于当 i>0i>0 时，dp[i][] 的值只和 dp[i−1][] 的值有关，
        // 因此可以将二维数组变成一维数组，将空间复杂度优化到 O(n)O(n)。
        /**
         * public int numWays(int n, int[][] relation, int k) {
                int[] dp = new int[n];
                dp[0] = 1;
                for (int i = 0; i < k; i++) {
                    int[] next = new int[n];
                    for (int[] edge : relation) {
                        int src = edge[0], dst = edge[1];
                        next[dst] += dp[src];
                    }
                    dp = next;
                }
                return dp[n - 1];
         }
         */
    }


}