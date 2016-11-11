package leetcode.MeetingRooms;

import leetcode.common.ds.Interval;

import java.util.Arrays;

/**
 * Created by ymyue on 6/5/16.
 * Throw exception during comparison and catch Exception to return false
 * Time complexity(O(nlogn)
 * Space complexity O(1)
 */
public class Solution2 {
    public boolean canAttendMeetings(Interval[] intervals) {
        try {
            Arrays.sort(intervals, (o1, o2) -> {
                if (o1.end <= o2.start)
                    return -1;
                else if (o1.start >= o2.end)
                    return 1;
                else
                    throw new RuntimeException();
            });
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
