package leetcode.MinimumHeightTrees;

import java.util.*;

/**
 * Created by ymyue on 1/23/16.
 * Time complexity: O(e)
 * Space complexity: O(e)
 */
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Set<Integer>[] sets = new Set[n];
        for (int i = 0; i < n; i++)
            sets[i] = new HashSet<> ();

        for (int[] edge : edges) {
            sets[edge[0]].add(edge[1]);
            sets[edge[1]].add(edge[0]);
        }

        List<Integer> result = new ArrayList<> ();
        if (n == 1) {
            result.add(0);
            return result;
        }

        Queue<Integer> queue = new ArrayDeque<> ();
        for (int i = 0; i < sets.length; i++) {
            if (sets[i].size() == 1)
                queue.offer(i);
        }

        int total = 0;
        while (total < n-2) {
            int count = queue.size();
            total += count;
            for (int i = 0; i < count; i++) {
                int j = queue.poll();
                for (int k : sets[j]) {
                    sets[k].remove(j);
                    if (sets[k].size() == 1)
                        queue.offer(k);
                }
            }
        }
        result.addAll(queue);
        return result;
    }
}
