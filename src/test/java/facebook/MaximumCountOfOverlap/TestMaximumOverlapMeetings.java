package facebook.MaximumCountOfOverlap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/29/14
 * Time: 12:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestMaximumOverlapMeetings {
    @Test
    public void test0() {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(0, 4));
        list.add(new Interval(1, 5));
        list.add(new Interval(2, 3));
        list.add(new Interval(4, 10));
        Solution s = new Solution();
        assertEquals(4, s.maxOverlapMeetings(list));
    }

    @Test
    public void test1() {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(0, 4));
        list.add(new Interval(1, 5));
        list.add(new Interval(2, 3));
        list.add(new Interval(4, 10));
        Solution2 s = new Solution2();
        assertEquals(3, s.maxOverlapCount(list));
    }
}
