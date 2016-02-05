package leetcode.RecoverBinarySearchTree;

import ds.TreeNode;

/**
 * Created by ymyue on 1/2/16.
 */
public class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        TreeNode pre = null;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                if(pre!=null && pre.val > cur.val){
                    if(first==null){first = pre;second = cur;}
                    else{second = cur;}
                }
                pre = cur;
                cur = cur.right;
            } else {
                TreeNode tmp = cur.left;
                while (tmp.right != null && tmp.right != cur)
                    tmp = tmp.right;

                if (tmp.right == null) {
                    tmp.right = cur;
                    cur = cur.left;
                } else {
                    tmp.right = null;
                    if(pre!=null && pre.val > cur.val){
                        if(first==null){first = pre;second = cur;}
                        else{second = cur;}
                    }
                    pre = cur;
                    cur = cur.right;
                }
            }
        }
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}
