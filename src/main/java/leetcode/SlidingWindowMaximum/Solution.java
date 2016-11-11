package leetcode.SlidingWindowMaximum;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by ymyue on 10/20/16.
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length-k+1];
        int i = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while (i < k-1)
            pq.offer(nums[i++]);
        while (i < nums.length) {
            pq.offer(nums[i]);
            result[i-k+1] = pq.peek();
            pq.remove(nums[i-k+1]);
            i++;
        }
        return result;
    }
}
