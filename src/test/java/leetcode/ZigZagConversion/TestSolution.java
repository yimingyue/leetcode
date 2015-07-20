package leetcode.ZigZagConversion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 5/17/15.
 */
public class TestSolution {
    @Test
    public void test1() {
        int numRows = 3;
        String s = "ABCD";
        assertEquals("ABDC", new Solution().convert(s, numRows));
    }
}
