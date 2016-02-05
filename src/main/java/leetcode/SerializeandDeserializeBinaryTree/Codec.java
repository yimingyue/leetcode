package leetcode.SerializeandDeserializeBinaryTree;

import ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 12/10/15.
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "null";
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append(",");
        while (!list.isEmpty()) {
            List<TreeNode> nList = new ArrayList<> ();
            for (TreeNode node : list) {
                if (node.left != null) {
                    sb.append(node.left.val);
                    sb.append(',');
                    nList.add(node.left);
                } else {
                    sb.append("null");
                    sb.append(',');
                }
                if (node.right != null) {
                    sb.append(node.right.val);
                    sb.append(',');
                    nList.add(node.right);
                } else {
                    sb.append("null");
                    sb.append(",");
                }
            }
            list = nList;
        }
        return sb.substring(0, sb.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        if (arr[0].equals("null"))
            return null;
        List<TreeNode> list = new ArrayList<> ();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        list.add(root);
        int i = 1;
        while (!list.isEmpty()) {
            List<TreeNode> nList = new ArrayList<> ();
            for (TreeNode node : list) {
                TreeNode left = arr[i].equals("null")  ? null : new TreeNode(Integer.parseInt(arr[i]));
                i++;
                TreeNode right = arr[i].equals("null")  ? null : new TreeNode(Integer.parseInt(arr[i]));
                i++;
                node.left = left;
                node.right = right;
                if (left != null)
                    nList.add(left);
                if (right != null)
                    nList.add(right);
            }
            list = nList;
        }
        return root;
    }
}
