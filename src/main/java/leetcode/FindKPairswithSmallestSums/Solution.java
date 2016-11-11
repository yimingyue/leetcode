package leetcode.FindKPairswithSmallestSums;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by ymyue on 7/16/16.
 * Time complexity: O(klogn)
 * Space complexity: O(n)
 */
public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[] idx = new int[n];
        List<int[]> result = new ArrayList<> ();
        if (nums1.length == 0 || nums2.length == 0)
            return result;
        Queue<Integer> queue = new PriorityQueue<> (n, (x, y) -> (nums1[x] + nums2[idx[x]]) - (nums1[y] + nums2[idx[y]]));
        for (int i = 0; i < n; i++)
            queue.offer(i);

        while (!queue.isEmpty() && result.size() < k) {
            int x = queue.poll();
            result.add(new int[] {nums1[x], nums2[idx[x]]});
            if (++idx[x] < nums2.length)
                queue.offer(x);
        }
        return result;
    }
}
