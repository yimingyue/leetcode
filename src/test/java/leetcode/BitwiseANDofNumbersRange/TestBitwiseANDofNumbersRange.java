package leetcode.BitwiseANDofNumbersRange;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 11/1/15.
 */
public class TestBitwiseANDofNumbersRange {
    @Test
    public void test0() {
        Solution s = new Solution();
        assertEquals(1, s.rangeBitwiseAnd(2147483647, 2147483647));
    }
}
