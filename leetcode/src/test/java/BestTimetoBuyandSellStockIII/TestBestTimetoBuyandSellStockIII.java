package BestTimetoBuyandSellStockIII;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/6/14
 * Time: 5:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestBestTimetoBuyandSellStockIII {
    @Test
    public void Test1() {
        int[] prices = {3,2,6,5,0,3};
        Solution s = new Solution();
        assertEquals(7, s.maxProfit(prices));
    }

    @Test
    public void Test2() {
        int[] prices = {6,1,3,2,4,7};
        Solution s = new Solution();
        assertEquals(7, s.maxProfit(prices));
    }

    @Test
    public void Test3() {
        int[] prices = {1,4,2,7};
        Solution s = new Solution();
        assertEquals(8, s.maxProfit(prices));
    }
}
