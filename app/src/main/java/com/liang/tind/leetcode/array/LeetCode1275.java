package com.liang.tind.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * created by sherlock
 * <p>
 * date 2019/12/29
 * <p>
 * A 和 B 在一个 3 x 3 的网格上玩井字棋。
 * <p>
 * 井字棋游戏的规则如下：
 * <p>
 * 玩家轮流将棋子放在空方格 (" ") 上。
 * 第一个玩家 A 总是用 "X" 作为棋子，而第二个玩家 B 总是用 "O" 作为棋子。
 * "X" 和 "O" 只能放在空方格中，而不能放在已经被占用的方格上。
 * 只要有 3 个相同的（非空）棋子排成一条直线（行、列、对角线）时，游戏结束。
 * 如果所有方块都放满棋子（不为空），游戏也会结束。
 * 游戏结束后，棋子无法再进行任何移动。
 * 给你一个数组 moves，其中每个元素是大小为 2 的另一个数组（元素分别对应网格的行和列），它按照 A 和 B 的行动顺序（先 A 后 B）记录了两人各自的棋子位置。
 * <p>
 * 如果游戏存在获胜者（A 或 B），就返回该游戏的获胜者；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
 * <p>
 * 你可以假设 moves 都 有效（遵循井字棋规则），网格最初是空的，A 将先行动。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
 * 输出："A"
 * 解释："A" 获胜，他总是先走。
 * "X  "    "X  "    "X  "    "X  "    "X  "
 * "   " -> "   " -> " X " -> " X " -> " X "
 * "   "    "O  "    "O  "    "OO "    "OOX"
 * 示例 2：
 * <p>
 * 输入：moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
 * 输出："B"
 * 解释："B" 获胜。
 * "X  "    "X  "    "XX "    "XXO"    "XXO"    "XXO"
 * "   " -> " O " -> " O " -> " O " -> "XO " -> "XO "
 * "   "    "   "    "   "    "   "    "   "    "O  "
 * 示例 3：
 * <p>
 * 输入：moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
 * 输出："Draw"
 * 输出：由于没有办法再行动，游戏以平局结束。
 * "XXO"
 * "OOX"
 * "XOX"
 * 示例 4：
 * <p>
 * 输入：moves = [[0,0],[1,1]]
 * 输出："Pending"
 * 解释：游戏还没有结束。
 * "X  "
 * " O "
 * "   "
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= moves.length <= 9
 * moves[i].length == 2
 * 0 <= moves[i][j] <= 2
 * moves 里没有重复的元素。
 * moves 遵循井字棋的规则。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-winner-on-a-tic-tac-toe-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode1275 {
    private int[][] wins;

    public String tictactoe(int[][] moves) {
        initWins();
        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();
        //模拟棋盘点为1~9;
        for (int i = 0; i < moves.length; i++) {
            //将落子点二维数组转为 一维 [1,3] =》 6(第二行，第三列为6)
            int position = moves[i][0] * 3 + moves[i][1];
            boolean flag = i % 2 == 0;
            if (flag) {
                A.add(position);
                if (checkWin(A)) {
                    return "A";
                }
            } else {
                B.add(position);
                if (checkWin(B)) {
                    return "B";
                }
            }
        }

        return moves.length == 9 ? "Draw" : "Pending";

    }

    private boolean checkWin(Set<Integer> set) {
        for (int[] win : wins) {
            boolean flag = true;
            // 将每一种获胜情况拿出来判断，如果AorB的落子情况 有包含获胜情况中的一种即获胜
            for (int i : win) {
                if (!set.contains(i)){
                    flag = false;
                    break;
                }
            }

            if (flag){
                return  true;
            }
        }
        return false;
    }

    private void initWins() {
        /**
         * 连成线的情况有8种
         * {0, 1, 2},
         * {3, 4, 5},
         * {6, 7, 8},
         * {0, 3, 6},
         * {1, 4, 7},
         * {2, 5, 8},
         * {0, 4, 8},
         * {2, 4, 6}
         */
        wins = new int[8][3];
        wins[0] = new int[]{0, 1, 2};
        wins[1] = new int[]{3, 4, 5};
        wins[2] = new int[]{6, 7, 8};
        wins[3] = new int[]{0, 3, 6};
        wins[4] = new int[]{1, 4, 7};
        wins[5] = new int[]{2, 5, 8};
        wins[6] = new int[]{0, 4, 8};
        wins[7] = new int[]{2, 4, 6};
    }
}
