package leetcode.GraphValidTree;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by ymyue on 1/23/16.
 */
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n == 1)
            return true;
        int[] d = new int[n];
        HashSet<Integer>[] sets = new HashSet[n];
        for (int[] edge : edges) {
            if (sets[edge[0]] == null)
                sets[edge[0]] = new HashSet<Integer> ();
            if (sets[edge[1]] == null)
                sets[edge[1]] = new HashSet<Integer> ();
            sets[edge[0]].add(edge[1]);
            sets[edge[1]].add(edge[0]);
            d[edge[0]]++;
            d[edge[1]]++;
        }

        LinkedList<Integer> queue = new LinkedList<Integer> ();
        for (int i = 0; i < n; i++) {
            if (d[i] == 0)
                return false;
            else if (d[i] == 1)
                queue.offer(i);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int i = queue.poll();
            count++;
            for (int j : sets[i]) {
                if (d[j] == 1) {
                    return count == n-1;
                } else {
                    d[j]--;
                    if (d[j] == 1)
                        queue.offer(j);
                    sets[j].remove(i);
                }
            }
        }
        return count == n;
    }
}
