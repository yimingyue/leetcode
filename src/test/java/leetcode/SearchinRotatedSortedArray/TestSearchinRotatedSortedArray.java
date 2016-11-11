package leetcode.SearchinRotatedSortedArray;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/8/14
 * Time: 10:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestSearchinRotatedSortedArray {
    @Test
    public void test1() {
        Solution solution = new Solution();
        int[] A = {3,1};
        int target = 1;
        assertEquals(1, solution.search(A, target));
    }
}
