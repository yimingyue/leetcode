package leetcode.SlidingWindowMaximum;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by ymyue on 7/9/16.
 * Time complexity: O(nlogK)
 * Space complexity: O(k)
 */
public class SolutionPriorityQueue {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0)
            return new int[0];
        int[] maxInWindow = new int[nums.length-k+1];
        if (k < 1 || k > nums.length)
            return maxInWindow;
        Queue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());
        int i = 0;
        while (i < k && i < nums.length)
            queue.offer(nums[i++]);
        while (i <= nums.length) {
            maxInWindow[i-k] = queue.peek();
            queue.remove(nums[i-k]);
            if (i < nums.length)
                queue.offer(nums[i]);
            i++;
        }
        return maxInWindow;
    }
}
