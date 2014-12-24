package dto;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/9/14
 * Time: 4:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestMedianofTwoSortedArrays {
    @Test
    public void test1() {
        int[] A = {1, 1};
        int[] B = {1, 1};
        Solution s = new Solution();
        assertEquals(1.0, s.findMedianSortedArrays(A, B));
    }

    @Test
    public void test2() {
        int[] A = {1, 1, 1};
        int[] B = {1, 1, 1};
        Solution s = new Solution();
        assertEquals(1.0, s.findMedianSortedArrays(A, B));
    }

    @Test
    public void test3() {
        int[] A = {1, 2};
        int[] B = {1, 2};
        Solution s = new Solution();
        assertEquals(1.5, s.findMedianSortedArrays(A, B));
    }
}
