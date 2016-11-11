package leetcode.CloneGraph;

import leetcode.common.ds.UndirectedGraphNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymyue on 7/9/16.
 * Time complexity: O(m+n) - m: number of edges, n: number of vertexes
 * Space complexity: O(n)
 */
public class SolutionDFS {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        return cloneGraph(map, node);
    }

    private UndirectedGraphNode cloneGraph(Map<UndirectedGraphNode, UndirectedGraphNode> map, UndirectedGraphNode node) {
        if (map.containsKey(node))
            return map.get(node);
        else {
            UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
            map.put(node, copy);
            for (UndirectedGraphNode neighbor : node.neighbors) {
                copy.neighbors.add(cloneGraph(map, neighbor));
            }
            return copy;
        }
    }
}
