package leetcode.DecodeString;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 10/7/16.
 */
public class TestSolution {
    Solution2 solution = new Solution2();

    @Test
    public void test0() {
        Assert.assertEquals("aa abcbc", solution.decodeString("3[a]2[bc]"));
    }
}
