package leetcode.WildcardMatching;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 6/13/15.
 */
public class TestSolution {
    Solution3 s = new Solution3();

    @Test
    public void test0() {
        assertEquals(false, s.isMatch("ac", "*ab"));
    }

    @Test
    public void test1() {
        assertEquals(true, s.isMatch("hi", "*?"));
    }

    @Test
    public void test2() {
        assertEquals(true, s.isMatch("", "*"));
    }

    @Test
    public void test3() {
        assertEquals(false, s.isMatch("abce", "abc*??"));
    }
}
