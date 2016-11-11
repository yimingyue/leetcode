package leetcode.ConvertaNumbertoHexadecimal;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 9/24/16.
 */
public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void test0() {
        Assert.assertEquals("1a", solution.toHex(26));
    }

    @Test
    public void test1() {
        Assert.assertEquals("ffffffff", solution.toHex(-1));
    }

    @Test
    public void test2() {
        Assert.assertEquals("0", solution.toHex(0));
    }

    @Test
    public void test3() {
        Assert.assertEquals("ffffffe2", solution.toHex(-30));
    }
}
