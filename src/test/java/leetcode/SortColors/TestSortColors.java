package leetcode.SortColors;

import org.junit.Test;

/**
 * Created by ymyue on 6/21/15.
 */
public class TestSortColors {
    @Test
    public void test1() {
        Solution solution = new Solution();
        solution.sortColors(new int[] {1, 0});
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        solution.sortColors(new int[] {1, 2, 0});
    }

    @Test
    public void test3() {
        Solution solution = new Solution();
        solution.sortColors(new int[] {0, 1, 0});
    }
}
