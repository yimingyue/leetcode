package leetcode.ShortestPalindrome;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 11/22/15.
 */
public class TestSolution2 {
    @Test
    public void test0() {
        Solution2 s = new Solution2();
        assertEquals("aaacecaaa", s.shortestPalindrome("aacecaaa"));
    }

    @Test
    public void test1() {
        Solution2 s = new Solution2();
        assertEquals("dcbabcd", s.shortestPalindrome("abcd"));
    }

    @Test
    public void test2() {
        Solution2 s = new Solution2();
        assertEquals("a", s.shortestPalindrome("a"));
    }

    @Test
    public void test3() {
        Solution2 s = new Solution2();
        assertEquals("aaaccaaa", s.shortestPalindrome("aaccaaa"));
    }
}
