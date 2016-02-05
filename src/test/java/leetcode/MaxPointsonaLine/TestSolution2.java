package leetcode.MaxPointsonaLine;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 1/10/16.
 */
public class TestSolution2 {
    @Test
    public void test0() {
        Solution2 solution2 = new Solution2();
        Point [] points = new Point[3];
        points[0] = new Point(2, 3);
        points[1] = new Point(3, 3);
        points[2] = new Point(-5, 3);
        assertEquals(3, solution2.maxPoints(points));
    }
}
