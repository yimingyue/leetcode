package leetcode.MedianofTwoSortedArrays;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by ymyue on 11/19/15.
 */
public class TestSolution2 {
    @Test
    public void test1() {
        int[] A = {1, 1};
        int[] B = {1, 1};
        Solution2 s = new Solution2();
        assertEquals(1.0, s.findMedianSortedArrays(A, B));
    }

    @Test
    public void test2() {
        int[] A = {1, 1, 1};
        int[] B = {1, 1, 1};
        Solution2 s = new Solution2();
        assertEquals(1.0, s.findMedianSortedArrays(A, B));
    }

    @Test
    public void test3() {
        int[] A = {1, 2};
        int[] B = {1, 2};
        Solution2 s = new Solution2();
        assertEquals(1.5, s.findMedianSortedArrays(A, B));
    }

    @Test
    public void test4() {
        int[] A = {};
        int[] B = {1};
        Solution2 s = new Solution2();
        assertEquals(1.0, s.findMedianSortedArrays(A, B));
    }

    @Test
    public void test5() {
        int[] A = {1, 1};
        int[] B = {1, 2};
        Solution2 s = new Solution2();
        assertEquals(1.0, s.findMedianSortedArrays(A, B));
    }

    @Test
    public void test6() {
        int[] A = {1};
        int[] B = {1};
        Solution2 s = new Solution2();
        assertEquals(1.0, s.findMedianSortedArrays(A, B));
    }
}
