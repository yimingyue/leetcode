package leetcode.FrogJump;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 9/17/16.
 */
public class TestSolution {
    Solution4 solution = new Solution4();

    @Test
    public void test0() {
        Assert.assertTrue(solution.canCross(new int[] {0,1,3,5,6,8,12,17}));
    }

    @Test
    public void test1() {
        Assert.assertFalse(solution.canCross(new int[]{0, 1, 2, 3, 4, 8, 9, 11}));
    }

    @Test
    public void test2() {
        Assert.assertFalse(solution.canCross(new int[]{0, 2}));
    }

    @Test
    public void test3() { Assert.assertFalse(solution.canCross(new int[]{0, 1, 3, 6, 7}));}

    @Test
    public void test4() {
        Assert.assertFalse(solution.canCross(new int[]{0,1,3,6,10,13,15,16,19,21,25}));
    }
}
