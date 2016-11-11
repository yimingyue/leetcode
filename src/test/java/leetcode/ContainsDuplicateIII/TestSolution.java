package leetcode.ContainsDuplicateIII;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by ymyue on 6/7/15.
 */
public class TestSolution {
    Solution4 solution = new Solution4();
    @Test
    public void test1() {
        assertFalse(solution.containsNearbyAlmostDuplicate(new int[]{1, 3, 1}, 1, 1));
    }

    @Test
    public void test2() {
        assertTrue(solution.containsNearbyAlmostDuplicate(new int[]{-1, -1}, 0, 1));
    }

    @Test
    public void test3() {
        assertTrue(solution.containsNearbyAlmostDuplicate(new int[]{-1, -1}, 1, -1));
    }

    @Test
    public void test4() {
        assertTrue(solution.containsNearbyAlmostDuplicate(new int[]{1, 3, 6, 2}, 1, 2));
    }

    @Test
    public void test5() {
        assertTrue(solution.containsNearbyAlmostDuplicate(new int[]{7, 1, 3}, 2, 3));
    }

    @Test
    public void test6() {
        assertFalse(solution.containsNearbyAlmostDuplicate(new int[]{-1, 2147483647}, 1, 2147483647));
    }
}
