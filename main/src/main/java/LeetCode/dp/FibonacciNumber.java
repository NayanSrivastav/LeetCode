package LeetCode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/fibonacci-number/
 */
public class FibonacciNumber {
    Map<Integer, Integer> dp = new HashMap<>();

    public static void main(String[] args) {
        FibonacciNumber driver = new FibonacciNumber();
        System.out.println(driver.fib(4));
    }

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if(dp.containsKey(n)){
            return dp.get(n);
        }
        return fib(n - 1) + fib(n - 2);
    }
}
