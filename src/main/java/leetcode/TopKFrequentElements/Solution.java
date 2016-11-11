package leetcode.TopKFrequentElements;

import java.util.*;

/**
 * Created by ymyue on 6/12/16.
 * Time complexity: O(nlogk)
 * Space complexity: O(n)
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num)+1);
            else
                map.put(num, 1);
        }

        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int value : map.values()) {
            pq.offer(value);
            if (pq.size() > k)
                pq.poll();
        }

        int threshold = pq.peek();
        for (int key : map.keySet()) {
            if (map.get(key) >= threshold)
                result.add(key);
        }
        return result;
    }
}
