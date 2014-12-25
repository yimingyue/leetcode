package facebook.ValidateBinarySearchTree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/24/14
 * Time: 4:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestValidateBinarySearchTree {
    @Test
    public void test() {
        Solution s = new Solution();
        String strings = "{5,14,#,1}";
        TreeNode root = serializeTreeNode(strings);
        assertEquals(s.isValidSearchBinaryTree(root), false);
    }

    public TreeNode serializeTreeNode(String string) {
        if (string.length() == 0)
            return null;
        TreeNode root = null;
        String[] strs = string.substring(1, string.length()-1).split(",");
        List<TreeNode> list = new ArrayList<>();
        int i = 0;
        if (strs[i].equals("#")) {
            return null;
        } else {
            int val = Integer.parseInt(strs[i]);
            root = new TreeNode(val);
            list.add(root);
        }
        i++;

        while (!list.isEmpty()) {
            List<TreeNode> nList = new ArrayList<>();
            for (TreeNode node : list) {
                if (node == null)
                     continue;
                else {
                    if (i == strs.length)
                        return root;
                    if (strs[i].equals("#"))
                        node.left = null;
                    else {
                        int val = Integer.parseInt(strs[i]);
                        node.left = new TreeNode(val);
                        nList.add(node.left);
                    }
                    i++;

                    if (i == strs.length)
                        return root;
                    if (strs[i].equals("#"))
                        node.right = null;
                    else {
                        int val = Integer.parseInt(strs[i]);
                        node.right = new TreeNode(val);
                        nList.add(node.right);
                    }
                    i++;
                }
            }
            list = nList;
        }
        return root;
    }
}
