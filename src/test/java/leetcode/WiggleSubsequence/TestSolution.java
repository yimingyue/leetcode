package leetcode.WiggleSubsequence;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 9/18/16.
 */
public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void test0() {
        Assert.assertEquals(7, solution.wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
    }
}
