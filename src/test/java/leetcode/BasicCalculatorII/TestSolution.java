package leetcode.BasicCalculatorII;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 1/14/16.
 */
public class TestSolution {
    @Test
    public void test0() {
        assertEquals(123, new Solution().calculate(" 123"));
    }

    @Test
    public void test2() {
        assertEquals(3, new Solution().calculate(" 1  + 2"));
    }

    @Test
    public void test3() {
        assertEquals(7, new Solution().calculate(" 1  + 2*3"));
    }

    @Test
    public void test4() {
        assertEquals(-3, new Solution().calculate(" 1  + 2*3/4 -5"));
    }
}
