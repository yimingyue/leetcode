package leetcode.WildcardMatching;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 6/13/15.
 */
public class TestSolution {
    @Test
    public void test0() {
        Solution2 s = new Solution2();
        assertEquals(false, s.isMatch("ac", "*ab"));
    }

    @Test
    public void test1() {
        Solution2 s = new Solution2();
        assertEquals(true, s.isMatch("hi", "*?"));
    }

    @Test
    public void test2() {
        Solution2 s = new Solution2();
        assertEquals(true, s.isMatch("", "*"));
    }

    @Test
    public void test3() {
        Solution2 s = new Solution2();
        assertEquals(false, s.isMatch("abce", "abc*??"));
    }
}
