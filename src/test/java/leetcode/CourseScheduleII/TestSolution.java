package leetcode.CourseScheduleII;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 1/23/16.
 */
public class TestSolution {
    @Test
    public void test0() {
        int[][] prerequesites = new int[][] {{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}};
        assertEquals(new int[10], new Solution().findOrder(10, prerequesites));
    }
}
