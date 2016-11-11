package leetcode.FractiontoRecurringDecimal;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 1/18/16.
 */
public class TestSolution {
    Solution3 solution = new Solution3();
    @Test
    public void test0() {
        assertEquals("-0.58(3)", solution.fractionToDecimal(7, -12));
    }

    @Test
    public void test1() {
        assertEquals("-0.58(3)", solution.fractionToDecimal(-7, 12));
    }

    @Test
    public void test2() {
        assertEquals("0.0000000004656612873077392578125", solution.fractionToDecimal(-1, -2147483648));
    }

    @Test
    public void test3() {
        Assert.assertEquals("3.(142857)", solution.fractionToDecimal(22, 7));
    }
}
