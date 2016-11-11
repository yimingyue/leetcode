package leetcode.CloneGraph;

import leetcode.common.ds.UndirectedGraphNode;

import java.util.*;

/**
 * Created by ymyue on 7/9/16.
 * Time complexity: O(m+n)
 * Space complexity: O(n)
 */
public class SolutionBFS {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Deque<UndirectedGraphNode> queue = new ArrayDeque<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode origin = queue.poll();
            UndirectedGraphNode copy = new UndirectedGraphNode(origin.label);
            map.put(origin, copy);
            for (UndirectedGraphNode neighbor : origin.neighbors) {
                if (!map.containsKey(neighbor))
                    queue.offer(neighbor);
            }
        }

        Set<UndirectedGraphNode> visited = new HashSet<> ();
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode origin = queue.poll();
            if (visited.contains(origin))
                continue;
            visited.add(origin);
            UndirectedGraphNode copy = map.get(origin);
            for (UndirectedGraphNode neighbor : origin.neighbors) {
                copy.neighbors.add(map.get(neighbor));
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                }
            }
        }
        return map.get(node);
    }
}
