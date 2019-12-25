package com.liang.tind.leetcode.strings;

/**
 * created by sherlock
 * <p>
 * date 2019/12/25
 * <p>
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: "I am Chinese"
 * 输出: "esenihC ma I"
 * <p>
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 * <p>
 * 说明：
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode186 {

    public static void main(String[] args) {
        System.out.println(reverseWords("I am Chinese"));
        System.out.println(reverseWords("   I am Chinese"));
        System.out.println(reverseWords("   I am Chinese   "));
        System.out.println(reverseWords("   I am    Chinese   "));
        System.out.println(reverseWords("   I  "));
    }

    public static String reverseWords(String s) {
        s = s.trim();
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                sb.append(c);
            } else {
                if (sb.length() > 0) {
                    result.append(sb.toString());
                    result.append(" ");
                    sb.setLength(0);
                }
            }
        }

        if (sb.length() > 0) {
            result.append(sb.toString());
            result.append(" ");
        }

//        return result.reverse().toString().trim();
        return reverseString(result.toString().trim());
    }

    private static String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length() - 1;
        char[] chars = s.toCharArray();
        for (int i = (n + 1) / 2; i >= 0; i--) {
            char temp = chars[i];
            chars[i] = chars[n - i];
            chars[n - i] = temp;
        }
        return new String(chars);
    }
}
