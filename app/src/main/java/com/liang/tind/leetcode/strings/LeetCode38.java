package com.liang.tind.leetcode.strings;

/**
 * created by sherlock
 * <p>
 * date 2019/12/25
 * <p>
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-and-say
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode38 {
    public static void main(String[] args) {
        String s = countAndSay(6);
        System.out.println(s);
    }

    public static String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        for (int i = 2; i <= n; i++) {
            char[] chars = sb.toString().toCharArray();
            sb.setLength(0);
            int count = 1;
            char pre = chars[0];
            for (int j = 0; j < chars.length; j++) {
                if (j != chars.length - 1 && chars[j] == chars[j + 1]) {
                    count++;
                    pre = chars[j];
                } else if (chars[j] == pre) {
                    sb.append(count).append(pre);
                    count = 1;
                } else {
                    sb.append("1").append(chars[j]);
                }
            }
        }

        return sb.toString();
    }
}
