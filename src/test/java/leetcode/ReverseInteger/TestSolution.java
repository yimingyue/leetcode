package leetcode.ReverseInteger;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 5/17/15.
 */
public class TestSolution {
    @Test
    public void test1() {
        int input = 1534236469;
        assertEquals(0, new Solution().reverse(input));
    }

    @Test
    public void test2() {
        int val = -1 % 10;
        System.out.println(val);
    }
}
