package leetcode.SlidingWindowMaximum;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ymyue on 10/20/16.
 */
public class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0)
            return new int[0];
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length-k+1];
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peek() == i - k)
                deque.poll();
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
                deque.pollLast();
            deque.offer(i);
            if (i-k+1 >= 0)
                result[i-k+1] = nums[deque.peek()];
        }
        return result;
    }
}
