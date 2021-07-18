package LeetCode.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/counting-bits/
 */
public class CountingBits {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(16)));
    }

    static Map<Integer, Integer> dp = new HashMap<>();

    public static int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            result[i] = getBits(i);
        }
        return result;
    }

    static int getBits(int n) {
        System.out.println("n is: "+n);
        int count = 0;
        if (n != 0) {
            if (isPowOf2(n)) {
                count = 1;
            } else {
                while (n > 0) {
                    count += n & 1;
                    System.out.print(n+" ");
                    n = n >> 1;
                }
            }
        }

        System.out.println();
        System.out.println();
        dp.put(n, count);
        return count;
    }

    static boolean isPowOf2(int num) {
        return num > 1 && (num & num - 1) == 0;
    }
}
