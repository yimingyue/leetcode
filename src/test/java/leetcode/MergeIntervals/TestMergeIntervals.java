package leetcode.MergeIntervals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/8/14
 * Time: 6:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestMergeIntervals {
    @Test
    public void Test1() {
        Solution2 solution2 = new Solution2();
        Interval interval1 = new Interval(1, 4);
        Interval interval2 = new Interval(0, 1);
        List<Interval> list = new ArrayList<>();
        list.add(interval1);
        list.add(interval2);
        solution2.merge(list);
    }
}
