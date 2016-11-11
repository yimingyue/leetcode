package leetcode.MeetingRooms;

import leetcode.common.ds.Interval;

import java.util.Arrays;

/**
 * Created by ymyue on 6/5/16.
 * Sort and compare
 * Time complexity O(nlogn)
 * Space complexity O(1)
 */
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, (inter1, inter2) -> inter1.start - inter2.start);
        for (int i = 1; i < intervals.length; i++)
            if (intervals[i].start < intervals[i-1].end)
                return false;
        return true;
    }
}
