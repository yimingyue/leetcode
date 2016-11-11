package leetcode.ClosestBinarySearchTreeValue;

import ds.TreeNode;

/**
 * Created by ymyue on 6/28/16.
 * Time complexity: O(logn)
 * Space complexity: O(1)
 */
public class Solution2 {
    public int closestValue(TreeNode root, double target) {
        TreeNode child = root.val < target ? root.right : root.left;
        if (child == null)
            return root.val;
        int childVal = closestValue(child, target);
        return Math.abs(root.val - target) < Math.abs(target - childVal) ? root.val : childVal;
    }
}
