package leetcode.ClosestBinarySearchTreeValueII;

import ds.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ymyue on 7/28/16.
 */
public class SolutionInOrderTraversal {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> result = new LinkedList<>();
        traversal(root, result, target, k);
        return result;
    }

    private void traversal(TreeNode root, Deque<Integer> queue, double target, int k) {
        if (root == null)
            return;
        traversal(root.left, queue, target, k);
        if (queue.size() == k) {
            if (Math.abs(queue.peek() - target) < Math.abs(root.val - target))
                return;
            queue.poll();
        }
        queue.offer(root.val);
        traversal(root.right, queue, target, k);
    }
}
