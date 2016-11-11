package leetcode.EvaluateDivision;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymyue on 9/24/16.
 */
public class Solution2 {
    class Node {
        String str;
        double val;
        Node parent;
        public Node (String str, double val) {
            this.str = str;
            this.val = val;
            this.parent = null;
        }
    }

    class Value {
        String str;
        double val;
        public Value(String str, double val) {
            this.str = str;
            this.val = val;
        }
    }
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Node> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            map.putIfAbsent(equations[i][0], new Node(equations[i][0], 1.0));
            map.putIfAbsent(equations[i][1], new Node(equations[i][1], 1.0));
            update(map.get(equations[i][0]), map.get(equations[i][1]), values[i]);
        }

        double[] result = new double[queries.length];
        int i = 0;
        for (String[] q : queries) {
            result[i++] = query(map.get(q[0]), map.get(q[1]));
        }
        return result;
    }

    public void update(Node node0, Node node1, double value) {
        double val0 = 1.0;
        while (node0.parent != null) {
            val0 *= node0.val;
            node0 = node0.parent;
        }

        double val1 = 1.0;
        while (node1.parent != null) {
            val1 *= node1.val;
            node1 = node1.parent;
        }

        if (node0 != node1) {
            node1.parent = node0;
            node1.val = value * val0 / val1;
        }
    }

    public double query(Node node0, Node node1) {
        if (node0 == null || node1 == null)
            return -1.0;
        double val0 = 1.0;
        while (node0.parent != null) {
            val0 *= node0.val;
            node0 = node0.parent;
        }

        double val1 = 1.0;
        while (node1.parent != null) {
            val1 *= node1.val;
            node1 = node1.parent;
        }

        return node0 == node1 ? val1 / val0 : -1.0;
    }
}
