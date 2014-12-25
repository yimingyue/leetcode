package leetcode.BestTimetoBuyandSellStockIII;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/6/14
 * Time: 5:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int[] profits = new int[prices.length-1];
        for (int i = 1; i < prices.length; i++) {
            profits[i-1] = prices[i] -prices[i-1];
        }

        int sum = 0;
        int max = 0;
        int startOffset = 0;
        int endOffset = 0;
        int newOffset = 0;
        for (int i = 0; i < profits.length; i++) {
            sum += profits[i];
            if (sum > max) {
                max = sum;
                startOffset = newOffset;
                endOffset = i;
            }
            if (sum < 0) {
                sum = 0;
                newOffset = i+1;
            }
        }

        int lmax = 0;
        sum = 0;
        for (int i = 0; i < startOffset; i++) {
            sum += profits[i];
            if (sum > lmax)
                lmax = sum;
            if (sum < 0)
                sum = 0;
        }

        int rmax = 0;
        sum = 0;
        for (int i = endOffset + 1; i < profits.length; i++) {
            sum += profits[i];
            if (sum > rmax)
                rmax = sum;
            if (sum < 0)
                sum = 0;
        }

        int min = 0;
        sum = 0;
        if (endOffset - startOffset >= 2) {
            for (int i = startOffset; i <= endOffset; i++) {
                sum += profits[i];
                if (sum < min)
                    min = sum;
                if (sum > 0)
                    sum = 0;
            }
        }

        return Math.max(Math.max(max + lmax, max + rmax), max - min);
    }
}
