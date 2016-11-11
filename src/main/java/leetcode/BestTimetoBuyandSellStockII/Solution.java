package leetcode.BestTimetoBuyandSellStockII;

/**
 * Created by ymyue on 6/22/16.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++)
            sum += Math.max(prices[i] - prices[i-1], 0);
        return sum;
    }
}
