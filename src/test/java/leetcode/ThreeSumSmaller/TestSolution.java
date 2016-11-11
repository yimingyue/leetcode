package leetcode.ThreeSumSmaller;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 10/20/16.
 */
public class TestSolution {
    Solution solution = new Solution();
    @Test
    public void test0() {
        Assert.assertEquals(2, solution.threeSumSmaller(new int[]{-2, 0, 1, 3}, 2));
    }
}
