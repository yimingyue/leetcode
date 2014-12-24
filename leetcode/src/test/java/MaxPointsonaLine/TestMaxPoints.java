package MaxPointsonaLine;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 11/28/14
 * Time: 3:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestMaxPoints {
    @Test
    public void TestNormal() {
        Point [] points = new Point[6];
        points[0] = new Point(1, 2);
        points[1] = new Point(1, 2);
        points[2] = new Point(4, 4);
        points[3] = new Point(6, 12);
        points[4] = new Point(2, 4);
        points[5] = new Point(1, 12);
        Solution s = new Solution();
        assertEquals(s.maxPoints(points), 4);
    }

    @Test
    public void TestCorner1() {
        Point [] points = new Point[1];
        points[0] = new Point(1, 2);
        Solution s = new Solution();
        assertEquals(1, s.maxPoints(points));
    }

    @Test
    public void TestCorner2() {
        Point [] points = new Point[4];
        points[0] = new Point(1, 2);
        points[1] = new Point(1, 2);
        points[2] = new Point(2, 4);
        points[3] = new Point(2, 4);
        Solution s = new Solution();
        assertEquals(4, s.maxPoints(points));
    }

    @Test
    public void TestCorner3() {
        Point [] points = new Point[3];
        points[0] = new Point(1, 2);
        points[1] = new Point(1, 2);
        points[2] = new Point(1, 2);
        Solution s = new Solution();
        assertEquals(3, s.maxPoints(points));
    }

    @Test
    public void TestNormal2() {
        Point [] points = new Point[3];
        points[0] = new Point(0, 0);
        points[1] = new Point(1, 1);
        points[2] = new Point(1, -1);
        Solution s = new Solution();
        assertEquals(2, s.maxPoints(points));
    }
}
