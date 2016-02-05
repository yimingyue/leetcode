package leetcode.BalancedBinaryTree;

import ds.TreeNode;

/**
 * Created by ymyue on 1/3/16.
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (!isBalanced(root.left) || !isBalanced(root.right))
            return false;
        int left = root.left == null ? 0 : root.left.val;
        int right = root.right == null ? 0 : root.right.val;
        if (Math.abs(left-right) >= 2)
            return false;
        root.val = 1 + Math.max(left, right);
        return true;
    }
}
