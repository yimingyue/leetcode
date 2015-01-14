package facebook.ReverseBinaryTree;

import ds.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/25/14
 * Time: 4:38 PM
 * To change this template use File | Settings | File Templates.
 */

/*
Question:
http://www.meetqun.com/thread-3421-1-6.html
 */
public class Solution {
    public void reverseBinaryTree(TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;
        TreeNode left = root.left;
        reverseBinaryTree(left);
        TreeNode right = root.right;
        reverseBinaryTree(root.right);
        root.left = null;
        root.right = null;
        if (left != null)
            left.right = root;
        if (right != null)
            right.left = root;
    }
}
