package dp;

import java.util.*;

public class AllPossibleFullBinaryTrees {

    static Map<Integer, List<TreeNode>> cache = new HashMap<>();
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public static void main(String[] args) {
        System.out.println(allPossibleFBT(7));
    }

    public static List<TreeNode> allPossibleFBT(int n) {

        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        List<TreeNode> result = new ArrayList<>();
        if (n == 1) {
            result.add(new TreeNode(0));
        }

        for (int i = 1; i < n; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - i - 1);
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode current = new TreeNode(0);
                    current.left = leftNode;
                    current.right = rightNode;
                    result.add(current);
                }
            }
        }

        cache.put(n, result);

        return result;
    }
}
