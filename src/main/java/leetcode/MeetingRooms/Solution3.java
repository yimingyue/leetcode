package leetcode.MeetingRooms;

import leetcode.common.ds.Interval;

import java.util.Arrays;

/**
 * Created by ymyue on 6/5/16.
 * Sort the start, end time separately
 * Time complexity: O(nlogn)
 * Space complexity: O(n)
 */
public class Solution3 {
    public boolean canAttendMeetings(Interval[] intervals) {
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        int i = 0;
        for (Interval interval : intervals) {
            starts[i] = interval.start;
            ends[i++] = interval.end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);
        for (i = 1; i < n; i++)
            if (starts[i] < ends[i-1])
                return false;
        return true;
    }
}
