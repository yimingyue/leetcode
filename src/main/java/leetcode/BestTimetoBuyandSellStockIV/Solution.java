package leetcode.BestTimetoBuyandSellStockIV;

/**
 * Created by ymyue on 11/26/15.
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k == 0)
            return 0;
        if( k >= prices.length / 2){
            int maxProfit = 0;
            for(int i = 1; i < prices.length; i++){
                maxProfit += Math.max(0, prices[i] - prices[i-1]);
            }
            return maxProfit;
        }
        if (prices.length < 2)
            return 0;
        int[] local = new int[k+1];
        int[] global = new int[k+1];
        for (int i = 0; i < prices.length-1; i++) {
            int diff = prices[i+1] - prices[i];
            for (int j = 0; j <= k; j++) {
                if (j == 0) {
                    global[j] = 0;
                    local[j] = 0;
                } else if (i == 0) {
                    global[j] = Math.max(0, diff);
                    local[j] = Math.max(0, diff);
                } else {
                    local[j] = Math.max(global[j-1] + Math.max(0, diff), local[j] + diff);
                    global[j] = Math.max(global[j], local[j]);
                }
            }
        }
        return global[k];
    }
}
