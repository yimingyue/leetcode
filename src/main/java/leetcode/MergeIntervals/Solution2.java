package leetcode.MergeIntervals;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/8/14
 * Time: 5:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution2 {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0)
            return intervals;
        List<Interval> list = new ArrayList<>();
        list.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            mergeList(list, interval);
        }
        return list;
    }

    private void mergeList(List<Interval> list, Interval interval) {
        Iterator<Interval> iter = list.iterator();
        while (iter.hasNext()) {
            Interval i = iter.next();
            if (i.start <= interval.start && i.end >= interval.end) {
                return;
            } else if (i.start >= interval.start && i.end <= interval.end) {
                iter.remove();
            } else if (i.start < interval.start && i.end >= interval.start && i.end <= interval.end) {
                iter.remove();
                interval = new Interval(i.start, interval.end);
            } else if (i.start < interval.start && i.end < interval.start) {
                continue;
            } else if (i.start >= interval.start && i.start <= interval.end && i.end > interval.end) {
                iter.remove();
                interval = new Interval(interval.start, i.end);
            } else {
                continue;
            }
        }
        list.add(interval);
    }
}
