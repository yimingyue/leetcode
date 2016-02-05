package leetcode.NumberofDigitOne;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 1/18/16.
 */
public class TestSolution {
    @Test
    public void test0() {
        assertEquals(1, new Solution().countDigitOne(1));
    }

    @Test
    public void test1() {
        assertEquals(2, new Solution().countDigitOne(10));
    }

    @Test
    public void test2() {
        assertEquals(12, new Solution().countDigitOne(19));
    }

    @Test
    public void test3() {
        assertEquals(44, new Solution().countDigitOne(115));
    }
}
