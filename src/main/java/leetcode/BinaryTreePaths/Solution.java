package leetcode.BinaryTreePaths;


import ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 7/27/16.
 * Time complexity: O(n)
 * Space complexity: O(logn)
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null)
            helper(result, new ArrayList<String> (), root);
        return result;
    }

    private void helper(List<String> result, List<String> path, TreeNode root) {
        path.add(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            result.add(String.join("->", path));
        } else {
            if (root.left != null)
                helper(result, path, root.left);
            if (root.right != null)
                helper(result, path, root.right);
        }
        path.remove(path.size()-1);
    }
}
