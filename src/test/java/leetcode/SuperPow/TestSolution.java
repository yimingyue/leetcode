package leetcode.SuperPow;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 9/19/16.
 */
public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void test0() {
        Assert.assertEquals(8, solution.superPow(2, new int[]{3}));
    }

    @Test
    public void test1() {
        Assert.assertEquals(1024, solution.superPow(2, new int[]{1, 0}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(85, solution.superPow(2, new int[]{1, 2}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(1198, solution.superPow(2147483647, new int[]{2, 0, 0}));
    }
}
