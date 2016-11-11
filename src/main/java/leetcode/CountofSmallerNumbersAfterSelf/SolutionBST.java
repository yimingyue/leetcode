package leetcode.CountofSmallerNumbersAfterSelf;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ymyue on 7/29/16.
 * Time complexity: O(nlogn)
 * Space complexity: O(n)
 */
public class SolutionBST {
    class TreeNode {
        int val;
        int dup;
        int smaller;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            this.val = x;
            this.dup = 1;
            this.smaller = 0;
        }
    }

    private TreeNode insert(TreeNode root, int x, Integer[] result, int i) {
        if (root == null) {
            root = new TreeNode(x);
            result[i] += 0;
        } else if (root.val == x) {
            root.dup++;
            result[i] += root.smaller;
        } else if (root.val < x) {
            result[i] += root.dup + root.smaller;
            root.right = insert(root.right, x, result, i);
        } else {
            root.smaller++;
            root.left = insert(root.left, x, result, i);
        }
        return root;
    }

    public List<Integer> countSmaller(int[] nums) {
        Integer[] result = new Integer[nums.length];
        Arrays.fill(result, 0);
        TreeNode root = null;
        for (int i = nums.length-1; i >= 0; i--)
            root = insert(root, nums[i], result, i);
        return Arrays.asList(result);
    }
}
