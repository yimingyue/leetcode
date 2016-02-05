package leetcode.ReverseBits;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 1/18/16.
 */
public class TestSolution {
    @Test
    public void test0() {
        assertEquals(2147483648L, new Solution2().reverseBits(1));
    }
}
