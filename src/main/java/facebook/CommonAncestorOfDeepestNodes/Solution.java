package facebook.CommonAncestorOfDeepestNodes;

/**
 * Created by ymyue on 2/2/16.
 */
public class Solution {
    public TreeNode getCommonAncestor(TreeNode root) {
        if (root == null)
            return root;
        if (root.children.isEmpty()) {
            root.maxDepth = 1;
            return root;
        }
        int count = 0;
        TreeNode candidate = null;
        for (TreeNode child : root.children) {
            TreeNode t = getCommonAncestor(child);
            if (candidate == null || t.maxDepth > candidate.maxDepth) {
                candidate = t;
                count = 1;
            } else if (t.maxDepth == candidate.maxDepth) {
                count++;
            }
        }
        if (count == root.children.size() && count > 1) {
            root.maxDepth = candidate.maxDepth+1;
            return root;
        }
        candidate.maxDepth++;
        return candidate;
    }
}
