package leetcode.MeetingRoomsII;

import leetcode.common.ds.Interval;

import java.util.TreeMap;

/**
 * Created by ymyue on 6/4/16.
 * Using TreeMap to sort the start/end time
 * Time complexity O(NlogN)
 * Space complexity O(N)
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<> ();
        for (Interval interval : intervals) {
            map.merge(interval.start, 1, Integer::sum);
            map.merge(interval.end, -1, Integer::sum);
        }
        int c = 0;
        int m = 0;
        for (int val : map.values()) {
            c += val;
            m = Math.max(m, c);
        }
        return m;
    }
}
