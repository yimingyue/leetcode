package leetcode.UniqueBinarySearchTreesII;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 8/23/15.
 */
public class Solution {

    public List<TreeNode> generateTrees(int n) {
        List<List<TreeNode>> nodeList = new ArrayList<> ();
        List<TreeNode> list0 = new ArrayList<> ();
        list0.add(null);
        nodeList.add(list0);
        List<TreeNode> list1 = new ArrayList<> ();
        TreeNode p = new TreeNode(1);
        list1.add(p);
        nodeList.add(list1);
        for (int i = 2; i <= n; i++) {
            List<TreeNode> list = new ArrayList<> ();
            for (int j = 0; j < i; j++) {
                for (TreeNode left : nodeList.get(j)) {
                    for (TreeNode right : nodeList.get(i-1-j)) {
                        TreeNode q = new TreeNode(i);
                        list.add(q);
                        q.left = copy(left, 0);
                        q.right = copy(right, i - 1 - right.val);
                    }
                }
            }
        }
        return nodeList.get(n);
    }

    private TreeNode copy(TreeNode root, int diff) {
        if (root == null)
            return null;
        TreeNode t = new TreeNode(root.val + diff);
        t.left = copy(root.left, diff);
        t.right = copy(root.right, diff);
        return t;
    }
}
