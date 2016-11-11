package leetcode.RemoveDuplicateLetters;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 7/17/16.
 */
public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void test0() {
        Assert.assertEquals("acb", solution.removeDuplicateLetters("ccacbaba"));
    }
}
