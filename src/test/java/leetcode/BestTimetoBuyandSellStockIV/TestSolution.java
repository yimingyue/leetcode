package leetcode.BestTimetoBuyandSellStockIV;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 11/26/15.
 */
public class TestSolution {
    @Test
    public void test() {
        int[] prices = new int[] {1,2,4,2,5,7,2,4,9,0};
        assertEquals(13, new Solution().maxProfit(2, prices));
    }

    @Test
    public void test1() {
        int[] prices = new int[] {1,2,4,2,5,7,2,4,9,0,9};
        assertEquals(17, new Solution().maxProfit(2, prices));
    }
}
