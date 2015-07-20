package leetcode.RemoveDuplicatesfromSortedArrayII;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by ymyue on 6/21/15.
 */
public class TestRemoveDuplicatesfromSortedArrayII {
    @Test
    public void test1() {
        Solution solution = new Solution();
        assertEquals(5, new Solution().removeDuplicates(new int[] {1,1,1,2,2,3}));
    }
}
