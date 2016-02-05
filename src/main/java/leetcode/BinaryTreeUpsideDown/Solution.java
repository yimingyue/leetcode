package leetcode.BinaryTreeUpsideDown;

import ds.TreeNode;

import java.util.Stack;

/**
 * Created by ymyue on 11/22/15.
 */
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null)
            return root;
        Stack<TreeNode> stack = new Stack<> ();
        Stack<Boolean> flag = new Stack<> ();
        stack.push(root);
        flag.push(true);
        TreeNode nRoot = null;
        TreeNode p = null;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            boolean f = flag.pop();
            if (f) {
                stack.push(node);
                flag.push(false);
                if (node.right != null) {
                    stack.push(node.right);
                    flag.push(true);
                }
                if (node.left != null) {
                    stack.push(node.left);
                    flag.push(true);
                }
            } else {
                node.left = null;
                node.right = null;
                if (nRoot == null) {
                    nRoot = node;
                    p = node;
                } else if (p.left == null) {
                    p.left = node;
                } else {
                    p.right = node;
                    p = p.right;
                }
            }
        }
        return nRoot;
    }
}
