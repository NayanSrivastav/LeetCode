package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimeToBuyandSellStock {

    Map<String, Integer> dp = new HashMap<>();

    public static void main(String[] args) {
        BestTimeToBuyandSellStock driver = new BestTimeToBuyandSellStock();
        System.out.println(driver.maxProfit(new int[]{
                2, 1, 4, 5, 2, 9, 7
        }));

        System.out.println(driver.calculate(new int[]{
            2, 1, 4, 5, 2, 9, 7
        },0, 0, false));
    }

    public int maxProfit(int[] prices) {
        return calculate(prices);
    }

    public int calculate(int[] prices, int index, int max, boolean buy) {
        String key = "" + index + buy + max;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        if (index == prices.length) {
            return max;
        }

        // when buy/sell
        int newMax = buy ? max + prices[index] : max - prices[index];
        int profit = calculate(prices, index + 1, newMax, !buy);

        // when pass
        int profitPass = calculate(prices, index + 1, max, buy);
        dp.put(key, Math.max(profit, profitPass));
        return dp.get(key);
    }


    /**
     * linear approach, not working though
     *
     * @param prices
     * @return
     */
    public int calculate(int[] prices) {
        int buyingPrice = Integer.MAX_VALUE;
        int profit = 0;
        boolean hasBought = false;

        int index = 0;
        while (index < prices.length) {
            if (hasBought) {
                int maxSellingPrice = prices[index];
                for (int i = index + 1; i < prices.length; i++) {
                    if (maxSellingPrice >= prices[i]) {
                        index = i;
                        break;
                    }
                    maxSellingPrice = prices[i];
                }

                profit = profit - buyingPrice + maxSellingPrice;
                hasBought = false;
                buyingPrice = Integer.MAX_VALUE;
            } else {
                if (buyingPrice > prices[index]) {
                    buyingPrice = prices[index];
                    index++;
                } else {
                    hasBought = true;
                }
            }
        }

        return Math.max(profit, 0);
    }

    // 6, 7, 3, 0, 1, 18, 9

}
