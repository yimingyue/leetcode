package leetcode.InsertIntervals;

import java.util.ArrayList;

/**
 * Created by ymyue on 4/19/14.
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        if (newInterval.start > newInterval.end)
            return intervals;

        if (newInterval.end < intervals.get(0).start) {
            intervals.add(0, newInterval);
            return intervals;
        }

        if (newInterval.start > intervals.get(intervals.size()-1).end) {
            intervals.add(newInterval);
            return intervals;
        }

        if (intervals.size() == 1) {
            Interval interval = intervals.get(0);
            if (interval.end < newInterval.start) {
                intervals.add(newInterval);
                return intervals;
            } else if (interval.start > newInterval.end) {
                intervals.add(0, newInterval);
                return intervals;
            } else {
                interval.start = interval.start < newInterval.start ? interval.start : newInterval.start;
                interval.end = interval.end > newInterval.end ? interval.end : newInterval.end;
                return intervals;
            }
        }

        int b = -1;
        int d = -1;
        int s = -1;
        int e = -1;
        Interval interval = intervals.get(0);
        Interval lastInterval = null;
        for (int i = 1; i < intervals.size(); i++) {
            lastInterval = interval;
            interval = intervals.get(i);

            // insert case
            if (lastInterval.end < newInterval.start && interval.start > newInterval.end) {
                intervals.add(i, newInterval);
                return intervals;
            }

            // merge case
            // inside
            if ((newInterval.start >= lastInterval.start && newInterval.end <= lastInterval.end)
                    || (newInterval.start >= interval.start && newInterval.end <= interval.end))
                return intervals;

            // overlapping
            if (newInterval.start >= lastInterval.start && newInterval.start <= interval.end) {
                if (newInterval.start <= lastInterval.end) {
                    b = i-1;
                    s = lastInterval.start;
                } else if (newInterval.start < interval.start){
                    b = i;
                    s = newInterval.start;
                } else {
                    b = i;
                    s = interval.start;
                }
            }

            if (newInterval.end >= lastInterval.start && newInterval.end <= interval.end) {
                if (newInterval.end <= lastInterval.end) {
                    d = i-1;
                    e = lastInterval.end;
                } else if (newInterval.end < interval.start) {
                    d = i-1;
                    e = newInterval.end;
                } else {
                    d = i;
                    e = interval.end;
                }
            }
        }

        if (b == -1) {
            b = 0;
            s = newInterval.start;
        }
        if (d == -1) {
            d = intervals.size()-1;
            e = newInterval.end;
        }

        for (int i = b; i <= d; i++) {
            intervals.remove(b);
        }
        intervals.add(b, new Interval(s, e));
        return intervals;
    }
}
