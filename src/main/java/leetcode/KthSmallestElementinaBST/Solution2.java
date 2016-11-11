package leetcode.KthSmallestElementinaBST;

import ds.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ymyue on 10/20/16.
 */
public class Solution2 {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (--k > 0) {
            TreeNode node = stack.pop();
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return stack.peek().val;
    }
}
