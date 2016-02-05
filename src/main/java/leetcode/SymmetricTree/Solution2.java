package leetcode.SymmetricTree;

import ds.TreeNode;

import java.util.LinkedList;

/**
 * Created by ymyue on 1/2/16.
 */
public class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        LinkedList<TreeNode> leftList = new LinkedList<> ();
        LinkedList<TreeNode> rightList = new LinkedList<> ();
        leftList.add(root.left);
        rightList.add(root.right);
        while (!leftList.isEmpty() && !rightList.isEmpty()) {
            TreeNode p = leftList.poll();
            TreeNode q = rightList.poll();
            if (p == null && q == null)
                continue;
            if (p == null || q == null || p.val != q.val)
                return false;
            leftList.add(p.left);
            leftList.add(p.right);
            rightList.add(q.right);
            rightList.add(q.left);
        }
        return leftList.isEmpty() && rightList.isEmpty();
    }
}
