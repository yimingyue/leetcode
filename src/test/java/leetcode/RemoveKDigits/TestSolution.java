package leetcode.RemoveKDigits;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 9/17/16.
 */
public class TestSolution {
    Solution2 solution = new Solution2();

    @Test
    public void test0() {
        Assert.assertEquals("1219", solution.removeKdigits("1432219", 3));
    }

    @Test
    public void test1() {
        Assert.assertEquals("200", solution.removeKdigits("10200", 1));
    }

    @Test
    public void test2() {
        Assert.assertEquals("0", solution.removeKdigits("10", 2));
    }

    @Test
    public void test3() {
        Assert.assertEquals("0", solution.removeKdigits("9", 1));
    }
}

