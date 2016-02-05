package leetcode.WiggleSortII;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by ymyue on 1/24/16.
 */
public class TestSolution {
    @Test
    public void test0() {
        int[] arr = new int[]{1, 5, 1, 1, 6, 4};
        new Solution().wiggleSort(arr);
        assertArrayEquals(new int[]{1, 5, 1, 4, 1, 6}, arr);
    }

    @Test
    public void test1() {
        int[] arr = new int[] {1,3,2,2,1,3};
        new Solution().wiggleSort(arr);
        assertArrayEquals(new int[]{1, 3, 2, 1, 2, 3}, arr);
    }
}
