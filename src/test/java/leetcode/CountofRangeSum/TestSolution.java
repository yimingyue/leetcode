package leetcode.CountofRangeSum;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 7/28/16.
 */
public class TestSolution {
    SolutionBST solution = new SolutionBST();

    @Test
    public void test0() {
        Assert.assertEquals(3, solution.countRangeSum(new int[] {-2, 5, -1}, -2, 2));
    }

    @Test
    public void test1() {
        Assert.assertEquals(8, solution.countRangeSum(new int[] {1, 1, 0, -2}, -3, 1));
    }

    @Test
    public void test2() {
        Assert.assertEquals(3, solution.countRangeSum(new int[] {-2147483647,0,-2147483647,2147483647}, -564, 3864));
    }
}
