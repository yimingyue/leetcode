package leetcode.CloneGraph;

import leetcode.common.ds.UndirectedGraphNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymyue on 10/21/16.
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        return cloneGrapsh(node, map);
    }

    private UndirectedGraphNode cloneGrapsh(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        if (node == null)
            return null;
        if (map.containsKey(node))
            return map.get(node);
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        for (UndirectedGraphNode neighbor : node.neighbors)
            copy.neighbors.add(cloneGrapsh(neighbor, map));
        return copy;
    }
}
