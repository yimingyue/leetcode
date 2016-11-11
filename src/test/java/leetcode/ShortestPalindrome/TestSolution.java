package leetcode.ShortestPalindrome;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 11/20/15.
 */
public class TestSolution {
    SolutionKMPImprove solution = new SolutionKMPImprove();
    @Test
    public void test0() {
        assertEquals("aaacecaaa", solution.shortestPalindrome("aacecaaa"));
    }

    @Test
    public void test1() {
        assertEquals("dcbabcd", solution.shortestPalindrome("abcd"));
    }

    @Test
    public void test2() {
        assertEquals("a", solution.shortestPalindrome("a"));
    }

    @Test
    public void test3() {
        assertEquals("ababbabbbababbbabbaba", solution.shortestPalindrome("ababbbabbaba"));
    }
}
