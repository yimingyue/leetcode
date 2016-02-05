package leetcode.MultiplyString;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 5/25/15.
 */
public class TestSolution {
    @Test
    public void test1() {
        Solution solution = new Solution();
        String num1 = "123";
        String num2 = "456";
        String r = solution.multiply(num1, num2);
        assertEquals("56088", r);
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        String num1 = "0";
        String num2 = "9999";
        String r = solution.multiply(num1, num2);
        assertEquals("0", r);
    }
}
