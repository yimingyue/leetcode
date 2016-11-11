package leetcode.NthDigit;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 9/17/16.
 */
public class TestSolution {
    Solution solution = new Solution();
    @Test
    public void test0() {
        Assert.assertEquals(0, solution.findNthDigit(11));
    }
}
