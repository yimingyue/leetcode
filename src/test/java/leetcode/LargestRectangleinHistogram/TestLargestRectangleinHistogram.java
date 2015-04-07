package leetcode.LargestRectangleinHistogram;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/25/14
 * Time: 12:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestLargestRectangleinHistogram {
    @Test
    public void test() {
        Solution s = new Solution();
        int [] a = {2,1,5,6,2,3};
        assertEquals(s.largestRectangleArea(a), 10);
    }

    @Test
    public void test2() {
        Solution2 s = new Solution2();
        int [] a = {2,1,5,6,2,3};
        assertEquals(s.largestRectangleArea(a), 10);
    }
}
