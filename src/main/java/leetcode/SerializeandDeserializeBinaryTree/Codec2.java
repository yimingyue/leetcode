package leetcode.SerializeandDeserializeBinaryTree;

import ds.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ymyue on 7/8/16.
 */
public class Codec2 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "null";
        Deque<TreeNode> queue = new ArrayDeque<> ();
        StringBuffer sb = new StringBuffer();
        queue.offer(root);
        sb.append(root.val);
        sb.append(",");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null) {
                sb.append("null,");
            } else {
                sb.append(node.left.val);
                sb.append(",");
                queue.offer(node.left);
            }
            if (node.right == null) {
                sb.append("null,");
            } else {
                sb.append(node.right.val);
                sb.append(",");
                queue.offer(node.right);
            }
        }
        return sb.substring(0, sb.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty())
            throw new IllegalArgumentException();
        String[] vals = data.split(",");
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (vals[0].equals("null"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < vals.length) {
            TreeNode node = queue.poll();
            if (vals[i].equals("null")) {
                node.left = null;
            } else {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.offer(node.left);
            }
            i++;
            if (vals[i].equals("null")) {
                node.right = null;
            } else {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }
}
