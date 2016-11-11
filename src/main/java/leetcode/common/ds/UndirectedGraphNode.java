package leetcode.common.ds;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 7/9/16.
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
}
