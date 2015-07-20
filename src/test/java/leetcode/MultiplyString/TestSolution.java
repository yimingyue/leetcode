package leetcode.MultiplyString;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 5/25/15.
 */
public class TestSolution {
    @Test
    public void test1() {
        Solution2 solution2 = new Solution2();
        String num1 = "123";
        String num2 = "456";
        String r = solution2.multiply(num1, num2);
        assertEquals("56088", r);
    }
}
