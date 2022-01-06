package dp;

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
        if (n == 0 || n == 1) {
            return n;
        }
        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        int ans = fib(n - 1) + fib(n - 2);
        dp.put(n, ans);
        return ans;
    }
}
