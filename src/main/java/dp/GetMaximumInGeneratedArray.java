package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/get-maximum-in-generated-array/
 */
public class GetMaximumInGeneratedArray {

    public static void main(String[] args) {
        GetMaximumInGeneratedArray driver = new GetMaximumInGeneratedArray();
        System.out.println(driver.getMaximumGenerated(7));
    }

    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }

        List<Integer> list = new ArrayList<>(n + 1);
        list.add(0);
        list.add(1);
        list.add(1);
        int max = 1;

        for (int i = 3; i < n + 1; i++) {
            if (i % 2 != 0) {
                list.add(list.get(i / 2) + list.get((i / 2) + 1));
            } else {
                list.add(list.get(i / 2));
            }
            max = Math.max(max, list.get(i));
        }

        System.out.println(list);
        return max;
    }
}
