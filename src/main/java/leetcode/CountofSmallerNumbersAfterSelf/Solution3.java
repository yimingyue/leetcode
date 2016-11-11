package leetcode.CountofSmallerNumbersAfterSelf;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ymyue on 10/5/16.
 */
public class Solution3 {
    public static class TreeNode {
        int val;
        int dup;
        int sum;
        TreeNode left;
        TreeNode right;
    }

    public List<Integer> countSmaller(int[] nums) {
        TreeNode root = null;
        Integer[] result = new Integer[nums.length];
        for (int i = nums.length-1; i >= 0; i--)
            root = addNode(root, result, i, 0, nums[i]);
        return Arrays.asList(result);
    }



    private TreeNode addNode(TreeNode root, Integer[] result, int i, int preSum, int val) {
        if (root == null) {
            TreeNode node = new TreeNode();
            node.dup = 1;
            node.val = val;
            node.sum = 0;
            result[i] = preSum;
            return node;
        } else {
            if (val == root.val) {
                root.dup++;
                result[i] = preSum + root.sum;
                return root;
            } else if (val < root.val) {
                root.sum++;
                root.left = addNode(root.left, result, i, preSum, val);
            } else {
                preSum += root.dup + root.sum;
                root.right = addNode(root.right, result, i, preSum, val);
            }
        }
        return root;
    }
}
