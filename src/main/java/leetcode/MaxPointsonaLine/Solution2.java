package leetcode.MaxPointsonaLine;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymyue on 1/10/16.
 */
public class Solution2 {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0)
            return 0;
        int max = 0;

        for (int i = 0; i < points.length; i++) {
            int dup = 0;
            int vertical = 1;
            Map<Double, Integer> map = new HashMap<>();
            for (int j = i+1; j < points.length; j++) {
                if (points[i].x == points[j].x) {
                    if (points[i].y == points[j].y) {
                        dup++;
                    } else {
                        vertical++;
                    }
                } else {
                    Double m =  (1.0 * (points[j].y - points[i].y)) / (points[j].x - points[i].x);
                    if (map.containsKey(m))
                        map.put(m, map.get(m)+1);
                    else
                        map.put(m, 2);
                }
            }
            max = Math.max(max, dup+vertical);
            for (int count : map.values())
                max = Math.max(max, dup+count);
        }
        return max;
    }
}
