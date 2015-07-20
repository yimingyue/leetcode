package leetcode.ContainsDuplicateIII;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by ymyue on 6/7/15.
 */
public class TestSolution {
    @Test
    public void test1() {
        assertFalse(new Solution().containsNearbyAlmostDuplicate(new int[] {1, 3, 1}, 1, 1));
    }

    @Test
    public void test2() {
        assertTrue(new Solution().containsNearbyAlmostDuplicate(new int[]{-1, -1}, 0, 1));
    }

    @Test
    public void test3() {
        assertTrue(new Solution().containsNearbyAlmostDuplicate(new int[]{-1, -1}, 1, -1));
    }

    @Test
    public void test4() {
        assertTrue(new Solution().containsNearbyAlmostDuplicate(new int[]{1, 3, 6, 2}, 1, 2));
    }
}
