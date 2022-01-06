package dp;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs
 */
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        MinCostClimbingStairs driver = new MinCostClimbingStairs();
        System.out.println(driver.minCostClimbingStairs(new int[]{
                1,100,1,1,1,100,1,1,100,1
        }));
    }

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) {
            return cost[0];
        }
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }

        int step1=0;
        int step2=0;

        int[]dp=new int[cost.length];
        dp[0]=cost[0];
        dp[1]=cost[1];


        for (int i = 2; i < cost.length; i++) {
            dp[i]=cost[i]+Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[cost.length-1], dp[cost.length-2]);
    }
}
