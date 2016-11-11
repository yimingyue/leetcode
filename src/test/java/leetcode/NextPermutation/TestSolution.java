package leetcode.NextPermutation;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 10/21/16.
 */
public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void test0() {
        int[] nums = new int[] {1, 2, 2};
        solution.nextPermutation(nums);
        Assert.assertArrayEquals(new int[]{2, 1, 2}, nums);
    }
}
