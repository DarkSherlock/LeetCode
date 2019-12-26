package com.liang.tind.leetcode;

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

        System.out.println(s);
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
}
