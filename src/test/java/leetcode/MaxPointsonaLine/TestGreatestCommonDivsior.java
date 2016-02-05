package leetcode.MaxPointsonaLine;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 11/28/14
 * Time: 2:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestGreatestCommonDivsior {
    @Test
    public void TestAll() {
        int x = 6;
        int y = 8;
        Solution s = new Solution();
        assertEquals(s.greatestCommonDivisor(x, y), 2);
        x = 3;
        y = 0;
        assertEquals(s.greatestCommonDivisor(x, y), 3);
        x = 12;
        y = 16;
        assertEquals(s.greatestCommonDivisor(x, y), 4);
    }
}
