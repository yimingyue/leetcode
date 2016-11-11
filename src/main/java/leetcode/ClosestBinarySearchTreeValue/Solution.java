package leetcode.ClosestBinarySearchTreeValue;

import ds.TreeNode;

/**
 * Created by ymyue on 6/28/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution {
    public int closestValue(TreeNode root, double target) {
        if (root.left != null && target < root.left.val)
            return closestValue(root.left, target);
        if (root.right != null && target > root.right.val)
            return closestValue(root.right, target);
        if (target < root.val) {
            if (root.left == null)
                return root.val;
            TreeNode p = root.left;
            while (p.right != null)
                p = p.right;
            if (root.val - target < target - p.val)
                return root.val;
            return closestValue(root.left, target);
        } else if (target > root.val) {
            if (root.right == null)
                return root.val;
            TreeNode p = root.right;
            while (p.left != null)
                p = p.left;
            if (target - root.val < p.val - target)
                return root.val;
            return closestValue(root.right, target);
        } else
            return root.val;
    }
}
