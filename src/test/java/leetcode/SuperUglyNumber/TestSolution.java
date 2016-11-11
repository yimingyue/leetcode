package leetcode.SuperUglyNumber;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 7/17/16.
 */
public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void test0() {
        solution.nthSuperUglyNumber(2, new int[]{2, 3, 5});
    }

    @Test
    public void test1() {
        solution.nthSuperUglyNumber(4, new int[]{2});
    }

    @Test
    public void test2() {
        Assert.assertEquals(4, solution.nthSuperUglyNumber(4, new int[]{2, 3, 5}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(32, solution.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
    }
}
