package leetcode.StrobogrammaticNumberIII;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 1/27/16.
 */
public class TestSolution {
    @Test
    public void test0() {
        assertEquals(3, new Solution().strobogrammaticInRange("50", "99"));
    }

    @Test
    public void test1() {
        assertEquals(1, new Solution().strobogrammaticInRange("150", "299"));
    }
}
