package leetcode.SingleNumberII;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/3/14
 * Time: 11:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestSolution {
    @Test
    public void Test1() {
        Solution s = new Solution();
        int [] array = {1};
        assertEquals(s.singleNumber(array), 1);
    }
}
