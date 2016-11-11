package leetcode.PerfectRectangle;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by ymyue on 9/17/16.
 * Time complexity: O(n*M)
 * Space complexity: O(M)
 */
public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length == 0)
            return false;
        int left = rectangles[0][0];
        int right = rectangles[0][2];
        int bottom = rectangles[0][1];
        int top = rectangles[0][3];
        int area = 0;
        for (int[] rectangle : rectangles) {
            area += (rectangle[2] - rectangle[0]) * (rectangle[3] - rectangle[1]);
            left = Math.min(left, rectangle[0]);
            right = Math.max(right, rectangle[2]);
            bottom = Math.min(bottom, rectangle[1]);
            top = Math.max(top, rectangle[3]);
        }
        if (area != (right - left) * (top - bottom))
            return false;
        Arrays.sort(rectangles, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<> ((a, b) -> a[2] - b[2]);
        boolean[] b = new boolean[top-bottom];
        for (int[] rectangle : rectangles) {
            while (!pq.isEmpty() && rectangle[0] >= pq.peek()[2]) {
                int[] rect = pq.poll();
                for (int i = rect[1]; i < rect[3]; i++)
                    b[i-bottom] = false;
            }
            for (int i = rectangle[1]; i < rectangle[3]; i++) {
                if (b[i-bottom])
                    return false;
                b[i-bottom] = true;
            }
            pq.offer(rectangle);
        }
        return true;
    }
}
