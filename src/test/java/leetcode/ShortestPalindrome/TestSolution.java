package leetcode.ShortestPalindrome;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 11/20/15.
 */
public class TestSolution {
    @Test
    public void test0() {
        Solution s = new Solution();
        assertEquals("aaacecaaa", s.shortestPalindrome("aacecaaa"));
    }

    @Test
    public void test1() {
        Solution s = new Solution();
        assertEquals("dcbabcd", s.shortestPalindrome("abcd"));
    }

    @Test
    public void test2() {
        Solution s = new Solution();
        assertEquals("a", s.shortestPalindrome("a"));
    }
}
