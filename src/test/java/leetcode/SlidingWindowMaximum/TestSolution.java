package leetcode.SlidingWindowMaximum;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 10/20/16.
 */
public class TestSolution {
    Solution2 solution = new Solution2();

    @Test
    public void test0() {
        Assert.assertArrayEquals(new int[]{3,3,5,5,6,7}, solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3));
    }
}
