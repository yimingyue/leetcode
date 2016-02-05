package leetcode.strStr;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by ymyue on 11/22/15.
 */
public class TestSolution3 {
    @Test
    public void test1() {
        Solution3 s = new Solution3();
        String haystack = "ababc";
        String needle = "abc";
        assertEquals(2, s.strStr(haystack, needle));
    }

    @Test
    public void test2() {
        Solution3 s = new Solution3();
        String haystack = "mississippi";
        String needle = "mississippi";
        assertEquals(s.strStr(haystack, needle), 0);
    }

    @Test
    public void test3() {
        Solution3 s = new Solution3();
        String haystack = "mississippi";
        String needle = "issip";
        assertEquals(4, s.strStr(haystack, needle));
    }

    @Test
    public void test4() {
        Solution3 s = new Solution3();
        String haystack = "babba";
        String needle = "bbb";
        assertEquals(-1, s.strStr(haystack, needle));
    }
}
