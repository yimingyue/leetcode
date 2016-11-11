package leetcode.RegularExpressionMatching;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 11/23/15.
 */
public class TestSolution {
    Solution2 solution = new Solution2();
    @Test
    public void test0() {
        assertEquals(true, solution.isMatch("aaa", "ab*ac*a"));
    }

    @Test
    public void test1() {
        assertEquals(true, solution.isMatch("aaa", "ab*a*c*a"));
    }

    @Test
    public void test2() {
        assertEquals(true, solution.isMatch("a", "ab*"));
    }
}
