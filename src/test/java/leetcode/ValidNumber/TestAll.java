package leetcode.ValidNumber;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/30/14
 * Time: 8:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestAll {
    @Test
    public void test0() {
        LeetcodeSolution s = new LeetcodeSolution();
        String str = "32.e-80123";
        assertEquals(true, s.isNumber(str));
    }

    @Test
    public void test1() {
        Solution s = new Solution();
        String str = ".0e";
        assertEquals(false, s.isNumber(str));
    }

    @Test
    public void test2() {
        Solution s = new Solution();
        String str = "-.";
        assertEquals(false, s.isNumber(str));
    }

    @Test
    public void test3() {
        Solution s = new Solution();
        String str = ".1";
        assertEquals(true, s.isNumber(str));
    }
}
