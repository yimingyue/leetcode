package leetcode.InsertIntervals;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 6/4/16.
 * Binary search to find insert position
 * Loop to add elements
 * Time complexity: O(logN) binary search + O(N) iteration
 * Space complexity: O(N)
 */
public class Solution2 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) { // [[1, 2], [4, 6], [7, 9]] [3, 5]
        List<Interval> list = new ArrayList<>();
        int pos = search(intervals, 0, intervals.size()-1, newInterval.start);  // 0
        for (int i = 0; i < pos; i++)
            list.add(new Interval(intervals.get(i).start, intervals.get(i).end));
        Interval inter = new Interval(newInterval.start, newInterval.end);

        // handle special case where the last interval before pos has overlap with the new one
        if (pos >= 0 && inter.start <= intervals.get(pos).end) {
            inter.start = Math.min(inter.start, intervals.get(pos).start);
            inter.end = Math.max(inter.end, intervals.get(pos).end);
        } else if (pos >= 0)
            list.add(new Interval(intervals.get(pos).start, intervals.get(pos).end));

        for (int i = pos + 1; i < intervals.size(); i++) {
            if (inter.end < intervals.get(i).start) {
                list.add(inter);
                for (int j = i; j < intervals.size(); j++)
                    list.add(new Interval(intervals.get(j).start, intervals.get(j).end));
                return list;
            } else {
                inter.end = Math.max(inter.end, intervals.get(i).end);
            }
        }
        list.add(inter);
        return list;
    }

    int search(List<Interval> intervals, int low, int high, int x) {
        if (low > high)
            return high;
        int mid = low + (high - low) / 2;
        if (x == intervals.get(mid).start)
            return mid;
        else if (x < intervals.get(mid).start)
            return search(intervals, low, mid-1, x);
        else
            return search(intervals, mid+1, high, x);
    }
}
