package leetcode.PostoderTraversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 2/8/14
 * Time: 10:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> rList = new ArrayList<Integer> ();
        if (root == null)
            return rList;

        Map<TreeNode, Integer> treeStatus = new HashMap<TreeNode, Integer>();
        Stack<TreeNode> s = new Stack<TreeNode> ();
        s.push(root);
        treeStatus.put(root, 0);
        while(!s.empty()) {
            TreeNode t = s.pop();
            if (treeStatus.get(t) == 0) {
                treeStatus.put(t, 1);
                s.push(t);
                if (t.right != null) {
                    s.push(t.right);
                    treeStatus.put(t.right, 0);
                }
                if (t.left != null) {
                    s.push(t.left);
                    treeStatus.put(t.left, 0);
                }
            } else {
                rList.add(t.val);
                treeStatus.remove(t);
            }
        }
        for (int i : rList) {
            System.out.println(i);
        }
        return rList;
    }
}
