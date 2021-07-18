package LeetCode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/house-robber/
 */
public class HouseRobber {
    static Map<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        // 6, 7, 3, 0, 1, 18, 9
        System.out.println(calc(new int[]{
                6, 7, 3, 0, 1, 18, 9
        }, 0));
    }

    private static int calc(int[] nums, int index) {
        if (cache.containsKey(index)) {
            return cache.get(index);
        }
        if (index >= nums.length) {
            return 0;
        }
        int sum = nums[index] + calc(nums, index + 2);
        int sum2 = calc(nums, index + 1);

        int ans = Math.max(sum, sum2);
        cache.put(index, ans);
        return cache.get(index);
    }
}
