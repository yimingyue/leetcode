package leetcode.BasicCalculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 1/11/16.
 */
public class TestSolution {
    @Test
    public void test0 () {
        assertEquals(new Solution().calculate("(1+(4+5+2)-3)+(6+8)"), 23);
    }

    @Test
    public void test1 () {
        assertEquals(new Solution().calculate("2147483647"), 2147483647);
    }

    @Test
    public void test2 () {
        assertEquals(new Solution().calculate("(7)-(0)+(4)"), 11);
    }
}
