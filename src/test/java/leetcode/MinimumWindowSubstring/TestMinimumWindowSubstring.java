package leetcode.MinimumWindowSubstring;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by ymyue on 6/21/15.
 */
public class TestMinimumWindowSubstring {
    @Test
    public void test1() {
        assertEquals("", new Solution().minWindow("a", "aa"));
    }

    @Test
    public void test2() {
        assertEquals("BANC", new Solution().minWindow("ADOBECODEBANC", "ABC"));
    }

    @Test
    public void test3() {
        assertEquals("ba", new Solution().minWindow("bba", "ab"));
    }

    @Test
    public void test4() {
        assertEquals("a", new Solution().minWindow("a", "a"));
    }

}
