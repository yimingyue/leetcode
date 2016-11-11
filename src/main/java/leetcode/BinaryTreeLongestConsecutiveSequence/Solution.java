package leetcode.BinaryTreeLongestConsecutiveSequence;

import ds.TreeNode;

/**
 * Created by ymyue on 10/19/16.
 */
public class Solution {
    public int longestConsecutive(TreeNode root) {
        return longestConsecutive(root, 0);
    }

    private int longestConsecutive(TreeNode root, int length) {
        if (root == null)
            return length;
        int leftLength = 0;
        int rightLength = 0;
        if (root.left != null && root.val + 1 == root.left.val)
            leftLength = longestConsecutive(root.left, length+1);
        else
            leftLength = longestConsecutive(root.left, 0);
        if (root.right != null && root.val + 1 == root.right.val)
            rightLength = longestConsecutive(root.right, length+1);
        else
            rightLength = longestConsecutive(root.right, 0);
        return Math.max(length+1, Math.max(leftLength, rightLength));
    }
}
