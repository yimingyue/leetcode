package linkedin.PrintTreeFollowUp;

import ds.TreeNode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * Created by ymyue on 10/13/16.
 */
public class Solution {

    public void printTree(TreeNode root) {
        if (root == null)
            return;
        int pos = 0;
        TreeNode node = root.left;
        while (node != null) {
            pos++;
            node = node.left;
        }
        Map<TreeNode, Integer> map = new HashMap<>();
        traversal(root, pos, map);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            pos = 0;
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                while (pos++ < map.get(node))
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

    private void traversal(TreeNode root, int pos, Map<TreeNode, Integer> map) {
        map.put(root, pos);
        if (root.left != null)
            traversal(root.left, pos-1, map);
        if (root.right != null)
            traversal(root.right, pos+1, map);
    }
}
