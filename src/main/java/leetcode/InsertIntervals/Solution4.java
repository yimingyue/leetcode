package leetcode.InsertIntervals;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 10/21/16.
 */
public class Solution4 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
            result.add(intervals.get(i++));
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i++).end);
        }
        result.add(newInterval);
        while (i < intervals.size())
            result.add(intervals.get(i++));
        return result;
    }
}
