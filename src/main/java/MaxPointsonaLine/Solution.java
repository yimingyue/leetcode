package MaxPointsonaLine;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 11/28/14
 * Time: 2:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public int maxPoints(Point [] points) {
        if (points.length <= 2)
            return points.length;
        Map<ArrayList<Integer>, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            Point p = points[i];
            for (int j = i+1; j < points.length; j++) {
                Point q = points[j];
                int A = p.y - q.y;
                int B = q.x - p.x;
                int C = p.x*q.y - q.x*p.y;
                int D = greatestCommonDivisor(greatestCommonDivisor(A, B), C);
                ArrayList<Integer> list = new ArrayList<>();
                if (D != 0) {
                    list.add(A/D);
                    list.add(B/D);
                    list.add(C/D);
                    if (map.containsKey(list)) {
                        Set<Integer> set = map.get(list);
                        set.add(i);
                        set.add(j);
                    } else {
                        Set<Integer> set = new HashSet<>();
                        set.add(i);
                        set.add(j);
                        map.put(list, set);
                    }
                }
            }
        }

        // All points are on the same point
        if (map.size() == 0)
            return points.length;

        int max = 0;
        for (Set<Integer> set : map.values()) {
            if (set.size() > max)
                max = set.size();
        }
        return max;
    }

    public int greatestCommonDivisor(int x, int y) {
        if (x == 0)
            return y;
        else if (y == 0)
            return x;

        if (Math.abs(x) < Math.abs(y)) {
            int t = x;
            x = y;
            y = t;
        }

        int m = x % y;
        if (m == 0)
            return y;
        else {
            x = y;
            y = m;
            return greatestCommonDivisor(x, y);
        }
    }
}
