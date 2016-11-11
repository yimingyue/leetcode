package leetcode.GuessNumberHigherorLowerII;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 7/20/16.
 */
public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void test0() {
        Assert.assertEquals(4, solution.getMoneyAmount(4));
    }

    @Test
    public void test1() {
        Assert.assertEquals(10, solution.getMoneyAmount(7));
    }
}
