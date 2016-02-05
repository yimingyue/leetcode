package facebook.CommonAncestorOfDeepestNodes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 2/2/16.
 */
public class TreeNode {
    int val;
    int maxDepth;
    List<TreeNode> children;
    public TreeNode(int val) {
        this.val = val;
        this.maxDepth = 0;
        this.children = new ArrayList<>();
    }
}

