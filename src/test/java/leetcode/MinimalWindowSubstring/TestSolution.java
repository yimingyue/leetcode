package leetcode.MinimalWindowSubstring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 11/17/15.
 */
public class TestSolution {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("a", s.minWindow("a", "a"));
    }

    @Test
    public void test1() {
        Solution s = new Solution();
        assertEquals("", s.minWindow("a", "aa"));
    }

    @Test
    public void test2() {
        Solution s = new Solution();
        assertEquals("aa", s.minWindow("aa", "aa"));
    }

    @Test
    public void test3() {
        Solution s = new Solution();
        assertEquals("BANC", s.minWindow("ADOBECODEBANC", "ABC"));
    }

}
