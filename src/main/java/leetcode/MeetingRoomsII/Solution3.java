package leetcode.MeetingRoomsII;

import ds.Interval;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by ymyue on 10/22/16.
 */
public class Solution3 {
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, (x, y) -> Integer.compare(x.start, y.start));
        PriorityQueue<Interval> pq = new PriorityQueue<>((x, y) -> Integer.compare(y.end, x.end));
        int maxCount = 0;
        for (Interval interval : intervals) {
            while (!pq.isEmpty() && pq.peek().end < interval.start)
                pq.poll();
            pq.offer(interval);
            maxCount = Math.max(maxCount, pq.size());
        }
        return maxCount;
    }
}
