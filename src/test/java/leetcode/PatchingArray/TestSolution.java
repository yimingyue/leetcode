package leetcode.PatchingArray;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 7/21/16.
 */
public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void test0() {
        Assert.assertEquals(1, solution.minPatches(new int[]{1, 3}, 6));
    }

    @Test
    public void test1() {
        Assert.assertEquals(2, solution.minPatches(new int[]{1, 5, 10}, 20));
    }

    @Test
    public void test2() {
        Assert.assertEquals(3, solution.minPatches(new int[]{}, 7));
    }

    @Test
    public void test3() {
        Assert.assertEquals(29, solution.minPatches(new int[] {1, 2, 3}, 2147483647));
    }
}
