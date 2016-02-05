package leetcode.strStr;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/12/14
 * Time: 1:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class TeststrStr {
    @Test
    public void test1() {
        Solution s = new Solution();
        String haystack = "ababc";
        String needle = "abc";
        assertEquals(2, s.strStr(haystack, needle));
    }

    @Test
    public void test2() {
        Solution2 s = new Solution2();
        String haystack = "mississippi";
        String needle = "mississippi";
        assertEquals(s.strStr(haystack, needle), 0);
    }

    @Test
    public void test3() {
        Solution2 s = new Solution2();
        String haystack = "ababc";
        String needle = "abc";
        assertEquals(2, s.strStr(haystack, needle));
    }

    @Test
    public void test4() {
        Solution2 s = new Solution2();
        String haystack = "babba";
        String needle = "bbb";
        assertEquals(-1, s.strStr(haystack, needle));
    }
}
