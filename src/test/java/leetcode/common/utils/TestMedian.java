package leetcode.common.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 6/5/16.
 */
public class TestMedian {
    Median median = new Median();

    @Test
    public void test0() {
        int[] arr = {1, 3, 4, 5, 6, 7};
        assertEquals(0, Double.compare(median.getMedian(arr), 4.5));
    }

    @Test
    public void test1() {
        int[] arr = {1, 7, 6, 4, 5, 3};
        assertEquals(0, Double.compare(median.getMedian(arr), 4.5));
    }

    @Test
    public void test2() {
        int[] arr = {1, 7, 6, 4, 5, 3, 9};
        assertEquals(0, Double.compare(median.getMedian(arr), 5));
    }
}
