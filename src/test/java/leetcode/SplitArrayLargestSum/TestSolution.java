package leetcode.SplitArrayLargestSum;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 10/8/16.
 */
public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void test0() {
        Assert.assertEquals(18, solution.splitArray(new int[]{7, 2, 5, 10, 8}, 2));
    }
}
