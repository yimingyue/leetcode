package leetcode.ClosestBinarySearchTreeValueII;

import ds.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by ymyue on 7/27/16.
 */
public class SolutionPQ {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Queue<TreeNode> pq = new PriorityQueue<>(k, (x, y) -> Math.abs(x.val - target) - Math.abs(y.val - target) < 0 ? -1 : 1);
        while (root != null) {
            pq.offer(root);
            if (root.val < target)
                root = root.right;
            else
                root = root.left;
        }
        List<Integer> result = new ArrayList<>();
        while (result.size() < k) {
            TreeNode node = pq.poll();
            result.add(node.val);
            if (node.val < target) {
                node = node.left;
                while (node != null) {
                    pq.offer(node);
                    node = node.right;
                }
            } else if (node.right != null) {
                node = node.right;
                while (node != null) {
                    pq.offer(node);
                    node = node.left;
                }
            }
        }
        return result;
    }
}
