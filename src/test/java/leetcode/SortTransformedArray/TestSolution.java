package leetcode.SortTransformedArray;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 7/27/16.
 */
public class TestSolution {
    Solution2 solution = new Solution2();

    @Test
    public void test0() {
        Assert.assertArrayEquals(new int[] {-23,-5,1,7}, solution.sortTransformedArray(new int[] {-4, -2, 2, 4}, -1, 3, 5));
    }

    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[] {1,3,7,9}, solution.sortTransformedArray(new int[] {-4, -2, 2, 4}, 0, -1, 5));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[]{1, 3, 3, 3}, solution.sortTransformedArray(new int[]{-4, -2, -2, -2}, 0, 1, 5));
    }
}
