package leetcode.MedianofTwoSortedArrays;

import org.junit.Assert;
import org.junit.Test;


/**
 * Created by ymyue on 11/19/15.
 */
public class TestSolution {
    Solution4 s = new Solution4();
    @Test
    public void test1() {
        int[] A = {1, 1};
        int[] B = {1, 1};
//        SolutionDeque s = new SolutionDeque();
        Assert.assertEquals(1.0, s.findMedianSortedArrays(A, B), 0.01);
    }

    @Test
    public void test2() {
        int[] A = {1, 1, 1};
        int[] B = {1, 1, 1};
//        SolutionDeque s = new SolutionDeque();
        Assert.assertEquals(1.0, s.findMedianSortedArrays(A, B), 0.01);
    }

    @Test
    public void test3() {
        int[] A = {1, 2};
        int[] B = {1, 2};
//        SolutionDeque s = new SolutionDeque();
        Assert.assertEquals(1.5, s.findMedianSortedArrays(A, B), 0.01);
    }

    @Test
    public void test4() {
        int[] A = {};
        int[] B = {1};
//        SolutionDeque s = new SolutionDeque();
        Assert.assertEquals(1.0, s.findMedianSortedArrays(A, B), 0.01);
    }

    @Test
    public void test5() {
        int[] A = {1, 1};
        int[] B = {1, 2};
//        SolutionDeque s = new SolutionDeque();
        Assert.assertEquals(1.0, s.findMedianSortedArrays(A, B), 0.01);
    }

    @Test
    public void test6() {
        int[] A = {1};
        int[] B = {1};
//        SolutionDeque s = new SolutionDeque();
        Assert.assertEquals(1.0, s.findMedianSortedArrays(A, B), 0.01);
    }

    @Test
    public void test7() {
        Assert.assertEquals(1.0, s.findMedianSortedArrays(new int[]{1, 2}, new int[]{1, 1}), 0.01);
    }


    @Test
    public void test8() {
        Assert.assertEquals(2.0, s.findMedianSortedArrays(new int[]{1, 2}, new int[] {1, 2, 3}), 0.01);
    }

    @Test
    public void test9() {
        Assert.assertEquals(2.5, s.findMedianSortedArrays(new int[]{2}, new int[] {1, 3, 4}), 0.01);
    }

    @Test
    public void test10() {
        Assert.assertEquals(3.5, s.findMedianSortedArrays(new int[]{1, 2, 6}, new int[] {3, 4, 5}), 0.01);
    }

    @Test
    public void test11() {
        Assert.assertEquals(2.5, s.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}), 0.01);}
}
