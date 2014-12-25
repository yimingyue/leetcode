package main.java.facebook.ValidateBinarySearchTree;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/24/14
 * Time: 4:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public boolean isValidSearchBinaryTree(TreeNode root) {
        if (root == null)
            return true;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        boolean firstElement = true;
        int lastVal = 0;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                if (firstElement) {
                    firstElement = false;
                    lastVal = p.val;
                }
                else {
                    if (p.val <= lastVal)
                        return false;
                    else
                        lastVal = p.val;
                }
                p = p.right;
            }
        }
        return true;
    }
}

/*
Question: http://www.meetqun.com/thread-3784-1-1.html

Keypoints:
 1) preorder traverse the tree. Make sure each element is larger than the prior one
 */
