package leetcode.TrappingRainWaterII;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 9/24/16.
 */
public class TestSolution {
    Solution2 solution = new Solution2();

    @Test
    public void test0() {
        Assert.assertEquals(4, solution.trapRainWater(new int[][]{
                {1,4,3,1,3,2},
                {3,2,1,3,2,4},
                {2,3,3,2,3,1}
        }));
    }

    @Test
    public void test1() {
        Assert.assertEquals(14, solution.trapRainWater(new int[][]{
                {12,13,1,12},{13,4,13,12},{13,8,10,12},{12,13,12,12},{13,13,13,13}}
        ));
    }

    @Test
    public void test2() {
        Assert.assertEquals(0, solution.trapRainWater(new int[][]{
                {2, 2, 2}, {2, 1, 2}, {2, 1, 2}, {2, 1, 2}
        }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(12, solution.trapRainWater(new int[][] {
                {5,8,7,7},{5,2,1,5},{7,1,7,1},{8,9,6,9},{9,8,9,9}
        }));
    }
}
