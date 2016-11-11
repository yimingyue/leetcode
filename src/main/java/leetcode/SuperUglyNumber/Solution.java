package leetcode.SuperUglyNumber;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by ymyue on 7/17/16.
 * Time complexity: O(?)
 * Space complexity: O(?)
 */
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(1);
        int pre = 0;
        int val = 0;
        int count = 0;
        while (count < n) {
            val = queue.poll();
            if (val != pre) {
                pre = val;
                for (int prime : primes) {
                    if (val <= Integer.MAX_VALUE / prime)
                        queue.offer(prime * val);
                }
                count++;
            }
        }
        return val;
    }
}
