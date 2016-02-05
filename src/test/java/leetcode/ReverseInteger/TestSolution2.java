package leetcode.ReverseInteger;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 11/22/15.
 */
public class TestSolution2 {
    @Test
    public void test1() {
        int input = 1534236469;
        assertEquals(0, new Solution2().reverse(input));
    }

    @Test
    public void test2() {
        int input = -123;
        assertEquals(-321, new Solution2().reverse(input));
    }
}
