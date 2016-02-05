package leetcode.BinaryTreeLevelOrderTraversalII;

import ds.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ymyue on 1/2/16.
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> rList = new LinkedList<>();
        if (root == null)
            return rList;
        List<TreeNode> list = new ArrayList<> ();
        list.add(root);
        while (!list.isEmpty()) {
            List<TreeNode> nList = new ArrayList<> ();
            List<Integer> iList = new ArrayList<> ();
            for (TreeNode t : list) {
                iList.add(t.val);
                if (t.left != null)
                    nList.add(t.left);
                if (t.right != null)
                    nList.add(t.right);
            }
            rList.addFirst(iList);
            list = nList;
        }
        return rList;
    }
}
