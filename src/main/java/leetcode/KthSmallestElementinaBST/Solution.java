package leetcode.KthSmallestElementinaBST;

import ds.TreeNode;

/**
 * Created by ymyue on 6/26/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            throw new IllegalArgumentException();
        int count = numberOfNodes(root.left);
        if (count == k-1)
            return root.val;
        else if (count > k-1)
            return kthSmallest(root.left, k);
        else
            return kthSmallest(root.right, k - count - 1);
    }

    private int numberOfNodes(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + numberOfNodes(root.left) + numberOfNodes(root.right);
    }
}
