package leetcode.InsertIntervals;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 6/4/16.
 * Straightforward solution
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
public class Solution3 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) { // [[1, 2], [4, 6], [7, 9]] [3, 5]
        List<Interval> list = new ArrayList<>();

        Interval inter = new Interval(newInterval.start, newInterval.end);

        for (int i = 0; i < intervals.size(); i++) {
            if (inter.start > intervals.get(i).end) {   // no overlap - newInterval is after
                list.add(new Interval(intervals.get(i).start, intervals.get(i).end));
            } else if (inter.end < intervals.get(i).start) { // no overlap any more - newInterval is before
                list.add(inter);
                for (int j = i; j < intervals.size(); j++)
                    list.add(new Interval(intervals.get(j).start, intervals.get(j).end));
                return list;
            } else {    // overlapping
                inter.start = Math.min(inter.start, intervals.get(i).start);
                inter.end = Math.max(inter.end, intervals.get(i).end);
            }
        }
        list.add(inter);    // new Interval is the largest
        return list;
    }
}
