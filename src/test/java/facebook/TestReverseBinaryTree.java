package facebook;

import ds.TreeNode;
import facebook.ReverseBinaryTree.Solution;
import org.junit.Test;

import static utils.BinaryTreeSerialization.serializeTreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/25/14
 * Time: 4:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestReverseBinaryTree {
    @Test
    public void test() {
        Solution s = new Solution();
        String str = "{1,2,3,4,5}";
        TreeNode root = serializeTreeNode(str);
        s.reverseBinaryTree(root);
    }
}
