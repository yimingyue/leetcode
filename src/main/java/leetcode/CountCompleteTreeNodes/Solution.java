package leetcode.CountCompleteTreeNodes;

import ds.TreeNode;

/**
 * Created by ymyue on 6/26/16.
 * Time complexity: O(logN*logN)
 */
public class Solution {
    public int countNodes(TreeNode root) {
        int left = getLeftDepth(root);
        int right = getRightDepth(root);
        if (left == right)
            return (1 << left) -1;
        else
            return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getLeftDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            depth++;
            root = root.left;
        }
        return depth;
    }

    private int getRightDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            depth++;
            root = root.right;
        }
        return depth;
    }
}
