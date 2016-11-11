package leetcode.BinarySearchTreeIterator;

import ds.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ymyue on 10/21/16.
 */
public class BSTIterator2 {
    Deque<TreeNode> stack = new ArrayDeque<>();
    public BSTIterator2(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        int result = node.val;
        node = node.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        return result;
    }
}
