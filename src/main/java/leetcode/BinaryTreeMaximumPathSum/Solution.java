package leetcode.BinaryTreeMaximumPathSum;

import ds.TreeNode;

/**
 * Created by ymyue on 1/3/16.
 */
public class Solution {
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        TreeNode dummy = new TreeNode(root.val);
        maxPathSum(root, dummy);
        return dummy.val;
    }

    private int maxPathSum(TreeNode root, TreeNode dummy) {
        int left = root.left == null ? 0 : maxPathSum(root.left, dummy);
        int right = root.right == null ? 0 : maxPathSum(root.right, dummy);
        int val = root.val;
        val += left > 0 ? left : 0;
        val += right > 0 ? right : 0;
        dummy.val = Math.max(dummy.val, val);
        return Math.max(Math.max(left, right) + root.val, root.val);
    }
}
