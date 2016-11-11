package leetcode.MaxSumofRectangleNoLargerThanK;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 7/18/16.
 */
public class TestSolution {
    Solution2 solution = new Solution2();

    @Test
    public void test0() {
        Assert.assertEquals(2, solution.maxSumSubmatrix(new int[][]{{1, 0, 1}, {0, -2, 3}}, 2));
    }

    @Test
    public void test1() {
        Assert.assertEquals(-1, solution.maxSumSubmatrix(new int[][]{{2, 2, -1}}, 0));
    }

    @Test
    public void test2() {
        Assert.assertEquals(3, solution.maxSumSubmatrix(new int[][]{{2, 2, -1}}, 3));
    }

    @Test
    public void test3() {
        Assert.assertEquals(10, solution.maxSumSubmatrix(new int[][] {{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}}, 10));
    }
}
