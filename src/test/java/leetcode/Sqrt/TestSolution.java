package leetcode.Sqrt;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 12/21/15.
 */
public class TestSolution {
    @Test
    public void test0() {
        Solution solution = new Solution();
        assertEquals(4, solution.mySqrt(17));
    }

    @Test
    public void test1() {
        Solution solution = new Solution();
        assertEquals(30, solution.mySqrt(932));
    }
}
