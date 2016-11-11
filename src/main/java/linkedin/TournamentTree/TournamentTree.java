package linkedin.TournamentTree;

import ds.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by ymyue on 10/13/16.
 */
public class TournamentTree {
    TreeNode root;
    public TournamentTree(int[] scores) {
        if (scores.length == 0)
            root = null;
        Queue<TreeNode> queue = new ArrayDeque<>();
        for (int score : scores) {
            queue.offer(new TreeNode(score));
        }
        while (queue.size() > 1) {
            int size = queue.size();
            while (size > 0) {
                TreeNode left = queue.poll();
                if (--size > 0) {
                    TreeNode right = queue.poll();
                    TreeNode parent = new TreeNode(Math.max(left.val, right.val));
                    parent.left = left;
                    parent.right = right;
                    queue.offer(parent);
                    size--;
                } else {
                    queue.offer(left);
                }
            }
        }
        root =  queue.poll();
    }

    public int findSecondBest() {
        TreeNode node = root;
        int max = Integer.MIN_VALUE;
        while (root != null) {
            if (root.left.val != root.val) {
                max = Math.max(root.left.val, max);
                root = root.right;
            } else {
                max = Math.max(root.right.val, max);
                root = root.left;
            }
        }
        return max;
    }
}
