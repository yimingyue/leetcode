package leetcode.SortColors;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by ymyue on 6/21/15.
 */
public class TestSortColors {
    Solution solution = new Solution();
    @Test
    public void test1() {
        int[] arr = new int[] {1, 0};
        solution.sortColors(arr);
        assertArrayEquals(new int[]{0, 1}, arr);
    }

    @Test
    public void test2() {
        int[] arr = new int[] {1, 2, 0};
        solution.sortColors(arr);
        assertArrayEquals(new int[] {0, 1, 2}, arr);
    }

    @Test
    public void test3() {
        Solution solution = new Solution();
        int[] arr = new int[] {0, 1, 0};
        solution.sortColors(arr);
        assertArrayEquals(new int[]{0, 0, 1}, arr);
    }

    @Test
    public void test4() {
        int[] arr = new int[] {1, 0, 0};
        solution.sortColors(arr);
        assertArrayEquals(new int[]{0, 0, 1}, arr);
    }
}
