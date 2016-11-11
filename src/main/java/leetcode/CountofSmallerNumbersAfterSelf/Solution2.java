package leetcode.CountofSmallerNumbersAfterSelf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ymyue on 10/5/16.
 */
public class Solution2 {
    public static class TreeNode {
        int val;
        int num;    // number of smaller value
        int count;  // count of the same value
        TreeNode left;
        TreeNode right;
    }

    TreeNode root = null;

    public int addNode(TreeNode root, int val) {
        if (root == null)
            return 0;
        if (val == root.val) {
            root.count++;
            return root.num;
        } else if (val < root.val) {
            root.num++;
            if (root.left == null) {
                root.left = new TreeNode();
                root.left.val = val;
                root.left.count = 1;
                root.left.num = 0;
                return 0;
            } else
                return addNode(root.left, val);
        } else {
            if (root.right == null) {
                root.right = new TreeNode();
                root.right.val = val;
                root.right.count = 1;
                root.right.num = 0;
                return root.num + root.count;
            } else {
                return root.num + root.count + addNode(root.right, val);
            }
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0)
            return result;
        root = new TreeNode();
        root.val = nums[nums.length-1];
        root.count = 1;
        root.num = 0;
        result.add(0);

        for (int i = nums.length-2; i >= 0; i--)
            result.add(addNode(root, nums[i]));
        Collections.reverse(result);
        return result;
    }
}
