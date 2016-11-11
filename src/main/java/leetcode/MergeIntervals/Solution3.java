package leetcode.MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ymyue on 5/31/16.
 */
public class Solution3 {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty())  return intervals;
        Collections.sort(intervals, (interval1, interval2) -> interval1.start - interval2.start);
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval> list = new ArrayList<>();
        for (Interval inter : intervals) {
            if (inter.start <= end) {
                end = Math.max(end, inter.end);
            } else {
                list.add(new Interval(start, end));
                start = inter.start;
                end = inter.end;
            }
        }
        list.add(new Interval(start, end));
        return list;
    }
}
