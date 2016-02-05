package leetcode.BestTimetoBuyandSellStock;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int sum = 0;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            sum += prices[i] - prices[i-1];
            if (sum < 0)
                sum = 0;
            else 
                max = Math.max(max, sum);
        }
        return max;
    }
}
