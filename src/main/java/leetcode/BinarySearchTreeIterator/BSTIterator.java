package leetcode.BinarySearchTreeIterator;

import java.util.Stack;

/**
 * Created by ymyue on 10/31/15.
 */
public class BSTIterator {
    Stack<TreeNode> stack = new Stack<> ();
    TreeNode current = null;

    public BSTIterator(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        current = stack.isEmpty() ? null : stack.pop();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return current != null;
    }

    /** @return the next smallest number */
    public int next() {
        if (current == null)
            return 0;
        int val = current.val;
        current = findNext(current);
        return val;
    }

    private TreeNode findNext(TreeNode node) {
        if (node == null)
            return null;
        if (node.right != null) {
            stack.push(node);
            TreeNode t = node.right;
            while (t != null) {
                stack.push(t);
                t = t.left;
            }
            return stack.pop();
        } else {
            if (stack.isEmpty())
                return null;
            else {
                TreeNode p = stack.pop();
                while (p.right == node && !stack.isEmpty()) {
                    node = p;
                    p = stack.pop();
                }
                return p.right == node ? null : p;
            }
        }
    }
}
