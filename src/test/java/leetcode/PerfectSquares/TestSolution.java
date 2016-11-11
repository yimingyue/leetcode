package leetcode.PerfectSquares;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 10/19/16.
 */
public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void test0() {
        Assert.assertEquals(3, solution.numSquares(12));
    }

    @Test
    public void test1() {
        Assert.assertEquals(2, solution.numSquares(13));
    }
}
