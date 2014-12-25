package main.java.leetcode.BinaryTreeMaxmumPath;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 2/21/14
 * Time: 6:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public int maxPathSum(TreeNode root) {
        traversal(root);
        return travel(root);
    }

    private void traversal(TreeNode p) {
        if (p.left == null && p.right == null)
            return;
        if (p.left == null) {
            traversal(p.right);
            if (p.val + p.right.val > p.val)
                p.val = p.val + p.right.val;
            return;
        }
        if (p.right == null) {
            traversal(p.left);
            if (p.val + p.left.val > p.val)
                p.val = p.val + p.left.val;
            return;
        }
        traversal(p.left);
        traversal(p.right);

        p.val = Math.max(p.val, Math.max(p.val + p.left.val, p.val + p.right.val));
    }

    private int travel(TreeNode p) {
        if (p.left == null && p.right == null)
            return p.val;
        if (p.left == null)
            return Math.max(p.val, travel(p.right));
        if (p.right == null)
            return Math.max(p.val, travel(p.left));
        int l = travel(p.left);
        int r = travel(p.right);
        int a = p.left.val < p.right.val ? p.left.val : p.right.val;
        return Math.max(Math.max(Math.max(p.val, p.val+a), l), r);
    }
}
