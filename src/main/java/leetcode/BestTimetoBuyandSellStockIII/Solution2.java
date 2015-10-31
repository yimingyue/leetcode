package leetcode.BestTimetoBuyandSellStockIII;

/**
 * Created by ymyue on 10/11/15.
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;
        int maxVal = 0;
        int sum = 0;
        int start = 0;
        int maxStart = 0;
        int maxEnd = -1;
        int[] diff = new int[prices.length-1];
        for (int i = 0; i < diff.length; i++) {
            diff[i] = prices[i+1] - prices[i];
        }
        for (int i = 0; i < diff.length; i++) {
            sum += diff[i];
            if (sum > maxVal) {
                maxVal = sum;
                maxEnd = i;
                maxStart = start;
            } else if (sum < 0) {
                sum = 0;
                start = i+1;
            }
        }

        sum = 0;
        int secondVal = 0;
        for (int i = 0; i < maxStart; i++) {
            sum += diff[i];
            if (sum > secondVal)
                secondVal = sum;
            else if (sum < 0)
                sum = 0;
        }

        sum = 0;
        for (int i = maxEnd + 1; i < diff.length; i++) {
            sum += diff[i];
            if (sum > secondVal)
                secondVal = sum;
            else if (sum < 0)
                sum = 0;
        }

        sum = 0;
        int minVal = 0;
        for (int i = maxStart; i <= maxEnd; i++) {
            sum += diff[i];
            if (sum < minVal)
                minVal = sum;
            else if (sum > 0)
                sum = 0;
        }

        return Math.max(maxVal + secondVal, maxVal - minVal);
    }
}
