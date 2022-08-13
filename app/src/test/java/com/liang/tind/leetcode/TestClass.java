package com.liang.tind.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 梁天德
 * @date 2019/12/24 14:51
 * desc
 */
public class TestClass {

    @org.junit.Test
    public void test() {
        String s = "aAbBcCdDeE";
        char[] chars = s.toCharArray();
//        System.out.println(chars[0]);
//        System.out.println(chars[0] ^= 32);
//        System.out.println(chars[1] ^= 32);
//        System.out.println(chars[0] |= 32);
//        System.out.println(chars[0] &= -33);

//        System.out.println(1^4);
//        System.out.println(5^4);

        for (char aChar : chars) {
            if (aChar >= 65 && aChar <= 90) {
                aChar = (char) (aChar + 32);
            }
        }
    }

    public int[][] flipAndInvertImage(int[][] A) {
        int colNum = A[0].length;
        for (int[] row : A) {
            for (int i = 0; i < colNum / 2 + 1; i++) {
                int temp = row[i] ^ 1;
                row[i] = row[colNum - i - 1] ^ 1;
                row[colNum - i - 1] = temp;
            }
        }

        return A;
    }

    @Test
    public void testSelfDividingNumbers() {
        selfDividingNumbers(1, 22);
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            String s = String.valueOf(i);
            boolean flag = true;

            for (Character num : s.toCharArray()) {
                if (num == '0' || i % Integer.valueOf(num.toString()) != 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                result.add(i);
            }
        }

        return result;
    }

    public int reverseBits(int n) {
        // 将 nn 视作一个长为 32 的二进制串，从低位往高位枚举 n 的每一位，将其倒序添加到翻转结果 rev 中。

        // 代码实现中，每枚举一位就将 n 右移一位，这样当前 n 的最低位就是我们要枚举的比特位。当 n 为 0 时即可结束循环。

        // 需要注意的是，在某些语言（如 \texttt{Java}Java）中，没有无符号整数类型，因此对 n 的右移操作应使用逻辑右移。

        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;

    }
}
