package google.SecondLargestInBST;

import ds.TreeNode;

/**
 * Created by ymyue on 10/15/16.
 */
public class Solution {

    public int secondLargestInBST(TreeNode root) {
        int[] result = new int[1];
        secondLargest(root, result, 0);
        return result[0];
    }

    public void secondLargest(TreeNode root, int[] result, int c) {
        if (root == null)
            return;
        secondLargest(root.right, result, c);

        if (++c == 2) {
            result[0] = root.val;
            return;
        }

        secondLargest(root.left, result, c);
    }
}
