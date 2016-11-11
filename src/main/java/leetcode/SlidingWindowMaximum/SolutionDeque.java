package leetcode.SlidingWindowMaximum;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ymyue on 7/9/16.
 * Time complexity: O(n)
 * Space complexity: O(k)
 */
public class SolutionDeque {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0)
            return new int[0];
        int[] result = new int[nums.length-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.pollLast();
            deque.offer(nums[i]);
            if (i >= k-1) {
                result[i-k+1] = deque.peek();
                if (nums[i-k+1] == deque.peek())
                    deque.poll();
            }
        }
        return result;
    }
}
