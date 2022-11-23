package com.liang.tind.leetcode.dp

/**
 *@author: lonnie.liang
 *date: 2022/05/15 00:09
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 *
 * 最初，黑板上有一个数字n。在每个玩家的回合，玩家需要执行以下操作：
 *
 * 选出任一x，满足0 < x < n且n % x == 0。
 * 用 n - x替换黑板上的数字n 。
 * 如果玩家无法执行这些操作，就会输掉游戏。
 *
 * 只有在爱丽丝在游戏中取得胜利时才返回true。假设两个玩家都以最佳状态参与游戏。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：true
 * 解释：爱丽丝选择 1，鲍勃无法进行操作。
 * 示例 2：
 *
 * 输入：n = 3
 * 输出：false
 * 解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
 *
 */
class LeetCode1025 {

    fun solution(n: Int): Boolean {
        /**
         * n=1 的时候，区间 (0,1) 中没有整数是 n 的因数，所以此时 Alice 败。
         * n=2 的时候，Alice 只能拿 1，n 变成 1，Bob 无法继续操作，故 Alice 胜。
         * n=3 的时候，Alice 只能拿 1，n 变成 2，根据 n=2 的结论，我们知道此时 Bob 会获胜，Alice 败。
         * n=4 的时候，Alice 能拿 1 或 2，如果 Alice 拿 1，根据 n=3 的结论，Bob 会失败，Alice 会获胜。
         * n=5 的时候，Alice 只能拿 1，根据 n=4 的结论，Alice 会失败。
         *
         * Alice 处在 n = kn=k 的状态时，他（她）做一步操作，必然使得 Bob 处于 n=m(m<k) 的状态。
         * 因此我们只要看是否存在一个 m 是必败的状态，那么 Alice 直接执行对应的操作让当前的数字变成 m，Alice 就必胜了
         * 如果没有任何一个是必败的状态的话，说明 Alice 无论怎么进行操作，最后都会让 Bob 处于必胜的状态，此时 Alice 是必败的。
         *
         * 结合以上我们定义 f[i] 表示当前数字 i 的时候先手是处于必胜态还是必败态，true 表示先手必胜，false 表示先手必败，
         * 从前往后递推，根据我们上文的分析，枚举 i 在 (0,i) 中 i 的因数 j，看是否存在 f[i−j] 为必败态即可。
         */

        // n+2 防止f[2]数组越界
        val f = BooleanArray(n + 2)
        f[1] = false
        f[2] = true
        for (i in 3..n) {
            for (j in 1 until i) {
                if (i % j == 0 && !f[i - j]) {
                    f[i] = true
                }
            }
        }

        return f[n]
    }
}