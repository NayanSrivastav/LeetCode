package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/n-th-tribonacci-number/
 */
public class NthTribonacciNumber {

    Map<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        NthTribonacciNumber driver = new NthTribonacciNumber();
        System.out.println(driver.tribonacci(10));
    }

    public int tribonacci(int n) {
        if (n == 0 ){
            return 0;
        } if(n == 1 || n == 2) {
            return 1;
        }

        if(cache.containsKey(n)){
            return cache.get(n);
        }
        int ans = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        cache.put(n, ans);

        return ans;
    }
}
