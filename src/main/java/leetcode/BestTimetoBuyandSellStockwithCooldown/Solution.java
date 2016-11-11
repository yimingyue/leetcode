package leetcode.BestTimetoBuyandSellStockwithCooldown;

/**
 * Created by ymyue on 7/22/16.
 * Time complexity: O(n)
 * Space complexity: O(n) - could be reduced to O(1)
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i < n; i++) {
            buy[i] = Math.max((i >= 2 ? sell[i-2] : 0) - prices[i], buy[i-1]);
            sell[i] = Math.max(buy[i] + prices[i], sell[i-1]);
        }
        return sell[n-1];
    }
}
