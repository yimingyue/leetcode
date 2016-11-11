package leetcode.PerfectRectangle;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 10/10/16.
 */
public class TestSolution {
    Solution2 solution = new Solution2();

    @Test
    public void test0() {
        Assert.assertFalse(solution.isRectangleCover(new int[][]{
                {0,0,1,1},{0,1,3,2},{1,0,2,2}
        }));
    }
}
