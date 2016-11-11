package leetcode.FlipGameII;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 7/16/16.
 */
public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void test0() {
        Assert.assertTrue(solution.canWin("++++"));
    }
}
