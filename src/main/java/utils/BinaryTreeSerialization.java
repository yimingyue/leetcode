package utils;

import ds.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/25/14
 * Time: 4:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class BinaryTreeSerialization {
    public static TreeNode serializeTreeNode(String string) {
        String[] strs = string.split(",");
        if (strs.length == 0 || strs[0].equals("#"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                TreeNode node = queue.poll();
                if (strs[i].equals("#"))
                    node.left = null;
                else {
                    node.left = new TreeNode(Integer.parseInt(strs[i]));
                    queue.offer(node.left);
                }
                if (++i == strs.length)
                    return root;
                if (strs[i].equals("#"))
                    node.right = null;
                else {
                    node.right = new TreeNode(Integer.parseInt(strs[i]));
                    queue.offer(node.right);
                }
                if (++i == strs.length)
                    return root;
            }
        }
        return root;
    }
}
