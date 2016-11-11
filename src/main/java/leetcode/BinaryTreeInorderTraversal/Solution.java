package leetcode.BinaryTreeInorderTraversal;


import ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 6/11/16.
 * Time complexit: O(n);
 * Space complexity: O(logn)
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }

    private void traversal(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        traversal(root.left, list);
        list.add(root.val);
        traversal(root.right, list);
    }
}
