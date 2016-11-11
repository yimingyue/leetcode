package leetcode.MaxPointsonaLine;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 11/28/14
 * Time: 2:45 PM
 * Time complexity: O(n2)
 * Space complexity: O(m)
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null)
            return 0;
        Map<List<Integer>, Set<Integer>> map = new HashMap<> ();
        int maxLines = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                if (points[i].x != points[j].x || points[i].y != points[j].y) {
                    List<Integer> line = getLine(points[i], points[j]);
                    Set<Integer> set = map.getOrDefault(line, new HashSet<Integer> ());
                    set.add(i);
                    set.add(j);
                    map.putIfAbsent(line, set);
                    maxLines = Math.max(maxLines, set.size());
                }
            }
        }

        // all points on the same point
        if (map.size() == 0)
            return points.length;
        return maxLines;
    }

    private List<Integer> getLine(Point p, Point q) {
        int x1 = p.x;
        int y1 = p.y;
        int x2 = q.x;
        int y2 = q.y;

        int a = y1 - y2;
        int b = x2 - x1;
        int c = x1*y2 - x2*y1;
        int g = gcd(gcd(a, b), c);

        a /= g;
        b /= g;
        c /= g;

        List<Integer> list = new ArrayList<> ();
        list.add(a);
        list.add(b);
        list.add(c);
        return list;
    }

    private int gcd(int x, int y) {
        if (x == 0)
            return y;
        if (y == 0)
            return x;
        if (x % y == 0)
            return y;
        else
            return gcd(y, x % y);
    }
}
