package com.liang.tind.leetcode.strings;

import java.util.Stack;

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
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
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
public class LeetCode151 {

    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        Stack<String> result = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                sb.append(c);
            } else {
                if (sb.length() > 0) {
                    result.push(sb.toString());
                    sb.setLength(0);
                }
            }
        }

        if(sb.length()>0){
            result.push(sb.toString());
            sb.setLength(0);
        }

        while (!result.isEmpty()){
            sb.append(result.pop());
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
