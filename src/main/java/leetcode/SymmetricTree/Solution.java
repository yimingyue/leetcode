package leetcode.SymmetricTree;

/**
 * Created by ymyue on 8/31/15.
 */

import ds.TreeNode;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return identical(root.left, root.right);
    }

    private boolean identical(TreeNode first, TreeNode second) {
        if (first == null && second == null)
            return true;
        if (first == null || second == null)
            return false;
        if (first.val != second.val)
            return false;
        return identical(first.left, second.right) && identical(first.right, second.left);
    }
}
