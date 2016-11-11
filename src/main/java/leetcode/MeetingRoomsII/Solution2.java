package leetcode.MeetingRoomsII;

import leetcode.common.ds.Interval;

import java.util.Arrays;

/**
 * Created by ymyue on 6/4/16.
 * https://leetcode.com/discuss/82292/explanation-super-easy-java-solution-beats-from-%40pinkfloyda
 */
public class Solution2 {
    public int minMeetingRooms(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        int i = 0;
        for (Interval interval : intervals) {
            starts[i] = interval.start;
            ends[i] = interval.end;
            i++;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int j = 0;
        for (i = 0; i < starts.length; i++) {
            if (starts[i] < ends[j] )
                rooms++;
            else
                j++;
        }
        return rooms;
    }
}
