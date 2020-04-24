package com.liang.tind.leetcode.array;

import java.util.ArrayDeque;

/**
 * created by sherlock
 * <p>
 * date 2019/12/29
 * <p>
 * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
 * <p>
 * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
 * <p>
 * 如果 S[i] == "I"，那么 A[i] < A[i+1]
 * 如果 S[i] == "D"，那么 A[i] > A[i+1]
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输出："IDID"
 * 输出：[0,4,1,3,2]
 * 示例 2：
 * <p>
 * 输出："III"
 * 输出：[0,1,2,3]
 * 示例 3：
 * <p>
 * 输出："DDI"
 * 输出：[3,2,0,1]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 1000
 * S 只包含字符 "I" 或 "D"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-string-match
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode942 {
    public int[] diStringMatch(String S) {
        int n = S.length();
        int min = 0;
        int max = n;

        int[] result = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == 'I') {
                result[i] = min++;
            } else {
                result[i] = max--;
            }
        }

        if (S.charAt(n - 1) == 'D') {
            result[n] = min;
        } else {
            result[n] = max;
        }

        return result;
    }


    ArrayDeque<Integer> queue = new ArrayDeque<>();
    public int ping(int t) {
        /**
         * 题目说的是，在时间点 t 进行一次 ping 操作，加上之前在 [t-3000, t]
         * 范围内的 ping 操作的次数，并将次数返回。
         * 例如，例子中第一次 ping 的 t = 1， 返回 1；
         * 第二次 ping 的 t = 100, 第一次 ping 的时间点 1 在本次允许范围
         * [100-3000, 100] 之内，所以返回2；
         * 第三次 ping 时，前两次的 ping 都在允许范围[3000-3000, 3000] 之内，所以返回 3；
         * 第四次 ping 时，第一次 ping 的 t = 1 不在允许范围[3002-3000, 3000] 之内，所以返回 3。
         * 利用队列先进先出的特点，移除当次 ping 操作不在允许范围内的时间点，剩下的队列内
         * 保存的都是允许范围内的时间点，最后返回队列的长度，即为当前时间点 t 所有允许范围
         * 内的 ping 操作次数。
         */
        while(!queue.isEmpty()){
            int val = queue.peek();
            if(val < t -3000){
                queue.pop();
            }else{
                //如果当前是允许的，那么后面的也都是允许的，直接结束循环
                break;
            }
        }
        queue.add(t);
        return queue.size();
    }
}
