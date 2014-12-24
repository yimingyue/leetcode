package PalindromePartitioningII;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/4/14
 * Time: 10:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestPalindromePartitioningII {
    @Test
    public void Test1() {
        Solution solution = new Solution();
        String s = "cdd";
        assertEquals(solution.minCut(s), 1);
    }

    @Test
    public void Test2() {
        Solution solution = new Solution();
        String s = "ab";
        assertEquals(1, solution.minCut(s));
    }

    @Test
    public void Test3() {
        Solution solution = new Solution();
        String s = "dde";
        assertEquals(1, solution.minCut(s));
    }
}
