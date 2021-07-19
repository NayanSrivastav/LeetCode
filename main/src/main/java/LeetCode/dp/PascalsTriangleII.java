package LeetCode.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 */
public class PascalsTriangleII {

    public static void main(String[] args) {
        PascalsTriangleII driver = new PascalsTriangleII();
        System.out.println(driver.getRow(3));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> prevList = new ArrayList<>();
        List<Integer> finalList = new ArrayList<>();
        prevList.add(1);
        prevList.add(1);
        if (rowIndex == 0) {
            return Collections.singletonList(1);
        } else if (rowIndex == 1) {
            return prevList;
        }

        for (int i = 2; i <= rowIndex; i++) {

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    finalList.add(1);
                } else {
                    finalList.add(getElementSafe(prevList, j - 1) + getElementSafe(prevList, j));
                }
            }
            prevList.clear();
            prevList.addAll(finalList);
            finalList.clear();
        }

        return prevList;
    }

    private int getElementSafe(List<Integer> list, int index) {
        if (index >= list.size()) {
            return 0;
        }
        return list.get(index);
    }
}
