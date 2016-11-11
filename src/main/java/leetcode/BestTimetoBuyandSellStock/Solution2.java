package leetcode.BestTimetoBuyandSellStock;

/**
 * Created by ymyue on 6/21/16.
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int lowest = prices[0];
        int maxProfit = 0;
        for (int price : prices) {
            maxProfit = Math.max(maxProfit, price - lowest);
            lowest = Math.min(lowest, price);
        }
        return maxProfit;
    }
}
