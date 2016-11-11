package leetcode.EvaluateDivision;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymyue on 9/24/16.
 * Time complexity: O(N^2)
 * Space complexity: O(n)
 */
public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        int index = 0;
        Map<String, Integer> ids = new HashMap<>();
        for (String[] equation : equations) {
            if (!ids.containsKey(equation[0]))
                ids.put(equation[0], index++);
            if (!ids.containsKey(equation[1]))
                ids.put(equation[1], index++);
        }

        Map<Integer, Integer> root = new HashMap<> ();
        for (int id = 0; id < index; id++)
            root.put(id, id);
        Map<Integer, Map<Integer, Double>> valueMap = new HashMap<> ();
        for (int id = 0; id < index; id++)
            valueMap.put(id, new HashMap<> ());
        for (int i = 0; i < equations.length; i++) {
            int u = ids.get(equations[i][0]);
            int v = ids.get(equations[i][1]);
            double du = 1.0;
            while (root.get(u) != u) {
                du *= valueMap.get(u).get(root.get(u));
                u = root.get(u);
            }
            double dv = 1.0;
            while (root.get(v) != v) {
                dv *= valueMap.get(v).get(root.get(v));
                v = root.get(v);
            }
            root.put(u, v);
            valueMap.get(u).put(v, values[i] * dv / du);
        }

        double[] result = new double[queries.length];
        int i = 0;
        for (String[] query : queries) {
            if (!ids.containsKey(query[0]) || !ids.containsKey(query[1])) {
                result[i++] = -1.0;
                continue;
            }
            int u = ids.get(query[0]);
            int v = ids.get(query[1]);
            double du = 1.0;
            while (root.get(u) != u) {
                du *= valueMap.get(u).get(root.get(u));
                u = root.get(u);
            }
            double dv = 1.0;
            while (root.get(v) != v) {
                dv *= valueMap.get(v).get(root.get(v));
                v = root.get(v);
            }
            if (u != v) {
                result[i++] = -1.0;
            } else {
                result[i++] = du / dv;
            }
        }
        return result;
    }
}
