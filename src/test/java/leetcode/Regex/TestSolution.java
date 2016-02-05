package leetcode.Regex;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 11/23/15.
 */
public class TestSolution {
    @Test
    public void test0() {
        assertEquals(true, new Solution().isMatch("aaa", "ab*ac*a"));
    }

    @Test
    public void test1() {
        assertEquals(true, new Solution().isMatch("aaa", "ab*a*c*a"));
    }

    @Test
    public void test2() {
        assertEquals(true, new Solution().isMatch("a", "ab*"));
    }
}
