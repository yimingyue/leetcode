package leetcode.ContainsDuplicateII;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by ymyue on 6/7/15.
 */
public class TestSolution {
    @Test
    public void test1() {
        assertEquals(true, new Solution().containsNearbyDuplicate(new int[] {99, 99}, 2));
    }
}
