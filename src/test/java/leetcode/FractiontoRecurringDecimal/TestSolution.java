package leetcode.FractiontoRecurringDecimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 1/18/16.
 */
public class TestSolution {
    @Test
    public void test0() {
        assertEquals("-0.58(3)", new Solution2().fractionToDecimal(7, -12));
    }

    @Test
    public void test1() {
        assertEquals("-0.58(3)", new Solution2().fractionToDecimal(-7, 12));
    }

    @Test
    public void test2() {
        assertEquals("0.0000000004656612873077392578125", new Solution2().fractionToDecimal(-1, -2147483648));
    }
}
