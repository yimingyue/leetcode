package leetcode.SerializeandDeserializeBinaryTree;

import ds.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Created by ymyue on 10/20/16.
 */
public class Codec3 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "#";
        return "" + root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new ArrayDeque<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return deserialize(queue);
    }

    private TreeNode deserialize(Queue<String> queue) {
        String str = queue.poll();
        if (str.equals("#"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(str));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }
}
