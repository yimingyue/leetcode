package leetcode.WiggleSortII;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by ymyue on 1/24/16.
 */
public class TestSolution {
    Solution4 solution = new Solution4();
    @Test
    public void test0() {
        int[] arr = new int[]{1, 5, 1, 1, 6, 4};
        solution.wiggleSort(arr);
        assertArrayEquals(new int[]{1, 6, 1, 5, 1, 4}, arr);
    }

    @Test
    public void test1() {
        int[] arr = new int[] {1,3,2,2,1,3};
        solution.wiggleSort(arr);
        assertArrayEquals(new int[]{2, 3, 1, 3, 1, 2}, arr);
    }

    @Test
    public void test2() {
        int[] arr = new int[] {4,5,5,6};
        solution.wiggleSort(arr);
        assertArrayEquals(new int[] {5, 6, 4, 5}, arr);
    }

    @Test
    public void test3() {
        int[] arr = new int[] {1};
        solution.wiggleSort(arr);
        assertArrayEquals(new int[] {1}, arr);
    }
}
