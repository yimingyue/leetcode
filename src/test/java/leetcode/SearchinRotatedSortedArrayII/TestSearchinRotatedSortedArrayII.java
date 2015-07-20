package leetcode.SearchinRotatedSortedArrayII;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by ymyue on 6/21/15.
 */
public class TestSearchinRotatedSortedArrayII {
    @Test
    public void test1() {
        Solution s = new Solution();
        int[] arr = new int[] {1, 3, 4};
        assertTrue(s.search(arr, 1));
    }
}
