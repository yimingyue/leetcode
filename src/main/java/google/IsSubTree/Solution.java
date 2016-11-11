package google.IsSubTree;

import ds.TreeNode;

/**
 * Created by ymyue on 10/16/16.
 */
public class Solution {
    public boolean isSubStree(TreeNode S, TreeNode T) {
        String s = serializeTree(S);
        String t = serializeTree(T);
        return s.contains(t);
    }

    private String serializeTree(TreeNode root) {
        if (root == null)
            return "";
        return serializeTree(root.left) + root.val + serializeTree(root.right) + "#";
    }
}
