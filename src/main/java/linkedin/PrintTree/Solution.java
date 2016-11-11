package linkedin.PrintTree;

import ds.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by ymyue on 10/13/16.
 */
public class Solution {
    public void printTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i != 0)
                    System.out.print(" ");
                System.out.print(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            System.out.println();
        }
    }
}
