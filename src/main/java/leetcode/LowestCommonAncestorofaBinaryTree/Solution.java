package leetcode.LowestCommonAncestorofaBinaryTree;

import ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 11/4/15.
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        List<TreeNode> list1 = new ArrayList<>();
        if (!getAncestors(root, p, list1))
            return null;
        List<TreeNode> list2 = new ArrayList<> ();
        if (!getAncestors(root, q, list2))
            return null;
        int i = 1;
        int j = 1;
        TreeNode common = root;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) != list2.get(j))
                break;
            common = list1.get(i);
            i++;
            j++;
        }
        return common;
    }

    private boolean getAncestors(TreeNode root, TreeNode p, List<TreeNode> list) {
        if (root == null)
            return false;
        if (root == p || getAncestors(root.left, p, list) || getAncestors(root.right, p, list)) {
            list.add(root);
            return true;
        }
        return false;
    }
}
