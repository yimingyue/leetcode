package leetcode.PerfectRectangle;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by ymyue on 10/10/16.
 */
public class Solution2 {
    public static class Interval implements Comparable<Interval> {
        int bottom;
        int top;

        public Interval(int bottom, int top) {
            this.bottom = bottom;
            this.top = top;
        }

        @Override
        public int compareTo(Interval interval) {
            if (this.top <= interval.bottom)
                return -1;
            if (this.bottom >= interval.top)
                return 1;
            return 0;
        }
    }

    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length == 0)
            return true;
        int area = 0;
        int left = rectangles[0][0];
        int bottom = rectangles[0][1];
        int right = rectangles[0][2];
        int top = rectangles[0][3];

        for (int[] rectangle : rectangles) {
            area += (rectangle[3] - rectangle[1]) * (rectangle[2] - rectangle[0]);
            left = Math.min(rectangle[0], left);
            right = Math.max(rectangle[2], right);
            bottom = Math.min(rectangle[1], bottom);
            top = Math.max(rectangle[3], top);
        }
        if (area != (right - left) * (top - bottom))
            return false;

        Arrays.sort(rectangles, (x, y) -> x[0] - y[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<> ((x, y) -> x[2] - y[2]);
        Set<Interval> set = new TreeSet<>();
        for (int[] rectangle : rectangles) {
            while (!pq.isEmpty() && pq.peek()[2] <= rectangle[0]) {
                int[] r = pq.poll();
                set.remove(new Interval(r[1], r[3]));
            }
            Interval interval = new Interval(rectangle[1], rectangle[3]);
            if (!set.add(interval))
                return false;
            pq.offer(rectangle);
        }
        return true;
    }

}
