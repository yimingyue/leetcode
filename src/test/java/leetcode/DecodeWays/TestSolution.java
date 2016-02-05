package leetcode.DecodeWays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 1/1/16.
 */
public class TestSolution {
    @Test
    public void test0() {
        Solution solution = new Solution();
        assertEquals(0, solution.numDecodings("0"));
    }

    @Test
    public void test1() {
        Solution solution = new Solution();
        assertEquals(1, solution.numDecodings("10"));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        assertEquals(2, solution.numDecodings("129"));
    }

    @Test
    public void test3() {
        Solution solution = new Solution();
        assertEquals(2, solution.numDecodings("227"));
    }

    @Test
    public void test4() {
        Solution solution = new Solution();
        assertEquals(1, solution.numDecodings("105"));
    }
}
