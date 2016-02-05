package leetcode.CourseScheduleII;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by ymyue on 1/23/16.
 */
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashSet<Integer>[] sets = new HashSet [numCourses];
        int[] d = new int[numCourses];

        for (int[] edge : prerequisites) {
            if (sets[edge[1]] == null) {
                sets[edge[1]] = new HashSet<Integer> ();
            }
            sets[edge[1]].add(edge[0]);
            d[edge[0]]++;
        }

        int[] result = new int[numCourses];
        LinkedList<Integer> queue = new LinkedList<> ();
        for (int i = 0; i < numCourses; i++) {
            if (d[i] == 0)
                queue.offer(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int i = queue.poll();
            result[count++] = i;
            if (sets[i] != null) {
                for (int j : sets[i]) {
                    --d[j];
                    if (d[j] == 0)
                        queue.offer(j);
                }
            }
        }
        return count == numCourses ? result : new int[0];
    }
}
