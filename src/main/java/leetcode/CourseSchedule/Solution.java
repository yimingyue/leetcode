package leetcode.CourseSchedule;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ymyue on 11/1/15.
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[][] transform = new boolean[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            transform[prerequisites[i][0]][prerequisites[i][1]] = true;
        }
        return !hasCircle(transform);
    }

    private boolean hasCircle(boolean[][] transform) {
        // the nodes have traveled in previous searches
        Set<Integer> set = new HashSet<> ();
        for (int i = 0; i < transform.length; i++) {
            if (set.contains(i))
                continue;
            // the nodes have traveled in current search
            Set<Integer> rSet = new HashSet<> ();
            // the nodes of current step in current search
            Set<Integer> nSet = new HashSet<> ();
            nSet.add(i);
            while (!nSet.isEmpty()) {
                // the nodes for next step in current search
                Set<Integer> tSet = new HashSet<> ();
                for (int j : nSet) {
                    for (int k = 0; k < transform[j].length; k++) {
                        if (!transform[j][k] || set.contains(k))
                            continue;
                        if (rSet.contains(k))
                            return true;
                        tSet.add(k);
                    }
                }
                rSet.addAll(nSet);
                nSet = tSet;
            }
            set.addAll(rSet);
        }
        return false;
    }
}
