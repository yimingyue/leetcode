package leetcode.ClosestBinarySearchTreeValueII;

import ds.TreeNode;

import java.util.*;

/**
 * Created by ymyue on 7/16/16.
 */
public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<TreeNode> leftStack = new ArrayDeque<>();
        Deque<TreeNode> rightStack = new ArrayDeque<> ();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer> (k+1, (x, y) -> Math.abs(y-target) < Math.abs(x-target) ? -1 : 1);
        while (root != null) {
            if (root.val < target) {
                leftStack.push(root);
                root = root.right;
            } else {
                rightStack.push(root);
                root = root.left;
            }
        }
        while (!leftStack.isEmpty() || !rightStack.isEmpty()) {
            TreeNode left = leftStack.isEmpty() ? null : leftStack.peek();
            TreeNode right = rightStack.isEmpty() ? null : rightStack.peek();
            if (left == null || (right != null && Math.abs(left.val-target) > Math.abs(right.val-target))) {
                if (pq.size() < k || Math.abs(pq.peek() - target) > Math.abs(right.val - target))
                    pq.offer(right.val);
                else
                    return new ArrayList<> (pq);
                if (pq.size() > k)
                    pq.poll();
                rightStack.pop();
                right = right.right;
                while (right != null) {
                    rightStack.push(right);
                    right = right.left;
                }
            } else {
                if (pq.size() < k || Math.abs(pq.peek()-target) > Math.abs(left.val - target))
                    pq.offer(left.val);
                else
                    return new ArrayList<>(pq);;
                if (pq.size() > k)
                    pq.poll();
                leftStack.pop();
                left = left.left;
                while (left != null) {
                    leftStack.push(left);
                    left = left.right;
                }
            }
        }
        return new ArrayList<> (pq);
    }
}
