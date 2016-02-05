package leetcode.FindtheDuplicateNumber;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 12/13/15.
 */
public class TestSolution {
    @Test
    public void test0() {
        Solution s = new Solution();
        int[] nums = new int[] {2,5,9,6,9,3,8,9,7,1};
        assertEquals(9, s.findDuplicate(nums));
    }

    @Test
    public void test1() {
        Solution s = new Solution();
        int[] nums = new int[] {8,7,1,10,17,15,18,11,16,9,19,12,5,14,3,4,2,13,18,18};
        assertEquals(18, s.findDuplicate(nums));
    }
}
