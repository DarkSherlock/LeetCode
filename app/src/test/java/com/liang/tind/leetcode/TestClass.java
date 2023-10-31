package com.liang.tind.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

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

        for (int i = 0; i < chars.length; i++) {
            // lower
            if (chars[i] >= 65 && chars[i] <= 90) {
                chars[i] = (char) (chars[i] + 32);
            }
        }

        int[] arr = new int[]{3, 2, 5, 1, 4};
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //o1是插入的元素，o2是上一个元素。 返回的结果大于0代表插入的元素比上一个元素大 需要排在后面，
                //即升序排列，即小顶堆，如果是要降序排列即大顶堆，需要返回复数，所以用o2-o1
                return o2 - o1;
            }
        });
        for (int i : arr) {
            pq1.offer(i);
            pq2.offer(i);
        }
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb1.append(pq1.poll().toString());
            sb2.append(pq2.poll().toString());
        }
        System.out.println("小顶堆:" + sb1.toString());
        System.out.println("大顶堆:" + sb2.toString());

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
                if (num == '0' || i % Integer.parseInt(num.toString()) != 0) {
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

    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }


    /**
     * 华为od机考 预定酒店
     */
    @Test
    public void testBookHotel() {
        int[] res1 = book(5, 6, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        Assert.assertArrayEquals(new int[]{4, 5, 6, 7, 8}, res1);

        int[] res2 = book(4, 6, new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1});
        Assert.assertArrayEquals(new int[]{4, 5, 6, 7}, res2);

        int[] res3 = book(3, 1000, new int[]{30, 30, 200, 500, 70, 300});
        Assert.assertArrayEquals(new int[]{200, 300, 500}, res3);

        int[] res4 = book(3, 1000, new int[]{1000, 1100, 900, 900, 70, 300});
        Assert.assertArrayEquals(new int[]{900, 900, 1000}, res4);
    }

    private int[] book(int k, int x, int[] prices) {
        int[] res = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int diff1 = Math.abs(o1 - x);
            int diff2 = Math.abs(o2 - x);
            if (diff1 == diff2) {
                return o1 - o2;
            } else {
                return diff1 - diff2;
            }
        });
        for (Integer price : prices) {
            queue.offer(price);
        }
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        Arrays.sort(res);
        return res;
    }

    @Test
    public void testBookHotel2() {
        int[] res1 = book2(5, 6, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        Assert.assertArrayEquals(new int[]{4, 5, 6, 7, 8}, res1);

        int[] res2 = book2(4, 6, new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1});
        Assert.assertArrayEquals(new int[]{4, 5, 6, 7}, res2);

        int[] res3 = book2(3, 1000, new int[]{30, 30, 200, 500, 70, 300});
        Assert.assertArrayEquals(new int[]{200, 300, 500}, res3);

        int[] res4 = book2(3, 1000, new int[]{1000, 1100, 900, 900, 70, 300});
        Assert.assertArrayEquals(new int[]{900, 900, 1000}, res4);
    }

    public int[] book2(int k, int x, int[] prices) {

        int numberOfWineshops = prices.length;
        int numberOfPickedWineshops = k;
        int referencePrice = x;

        int[] WineshopPrices = prices;

        Arrays.sort(WineshopPrices);

        int[][] priceDifference = new int[numberOfWineshops][2];
        for (int i = 0; i < numberOfWineshops; i++) {
            int price = WineshopPrices[i];
            priceDifference[i][0] = price;
            priceDifference[i][1] = Math.abs(price - referencePrice);
        }

        List<int[]> sortedPriceDifference = Arrays.stream(priceDifference)
                .sorted(Comparator.comparingInt(Wineshop -> Wineshop[1]))
                .collect(Collectors.toList());

        int[] pickedWineshopPrices = new int[numberOfPickedWineshops];
        for (int i = 0; i < numberOfPickedWineshops; i++) {
            pickedWineshopPrices[i] = sortedPriceDifference.get(i)[0];
        }

        Arrays.sort(pickedWineshopPrices);

//            for (int i = 0; i < pickedWineshopPrices.length; i++) {
//                System.out.print(pickedWineshopPrices[i]);
//                if (i != pickedWineshopPrices.length - 1) {
//                    System.out.print(" ");
//                }
//            }

        return pickedWineshopPrices;
    }


    @Test
    public void testMsg(){
        Assert.assertEquals(70, testMskSolution(6, new int[]{10,20,30,40,60}));
        Assert.assertEquals(210, testMskSolution(15, new int[]{10,20,30,40,60,60,70,80,90,150}));
    }

    public int testMskSolution(int money, int[] msgs) {

        int n = msgs.length; //获取列表大小
        int[] dp = new int[money + 1]; //定义大小为money+1的整型数组，初始值为0

//        for (int i = 1; i <= n; i++) { //循环遍历每个元素
//            int vi = msgs[i - 1]; //获取当前元素的值
//            for (int j = money; j >= i; j--) { //循环遍历每个可能的金额
//                int dp_j_i = dp[j - i]; //获取上一个状态的值
//                dp[j] = Math.max(dp[j], dp_j_i + vi); //更新当前状态的值
//            }
//        }

        for (int i = 1; i <= n; i++) { //循环遍历每个元素
            int vi = msgs[i - 1]; //获取当前元素的值
            for (int j = i; j <= money; j++) { //循环遍历每个可能的金额
                int dp_j_i = dp[j - i]; //获取上一个状态的值
                dp[j] = Math.max(dp[j], dp_j_i + vi); //更新当前状态的值
            }
        }

        System.out.println(dp[money]); //输出最终状态的值
        return dp[money];
    }
    
}