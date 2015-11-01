package leetcode.CourseSchedule;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by ymyue on 11/1/15.
 */
public class TestCourseSchedule {
    @Test
    public void test0() {
        int n = 3;
        int[][] arr = new int[][] {
                {1, 0},
                {0, 2},
                {2, 1}
        };
        assertFalse(new Solution().canFinish(n, arr));
    }

    @Test
    public void test1() {
        int n = 3;
        int[][] arr = new int[][] {
                {0, 1},
                {0, 2},
                {1, 2}
        };
        assertTrue(new Solution().canFinish(n, arr));
    }
}
