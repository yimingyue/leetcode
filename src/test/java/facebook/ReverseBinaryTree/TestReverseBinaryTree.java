package facebook.ReverseBinaryTree;

import ds.TreeNode;
import org.junit.Test;
import utils.BinaryTreeSerialization;


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
        String str = "1,2,3,4,5";
        TreeNode root = new BinaryTreeSerialization().serializeTreeNode(str);
        s.reverseBinaryTree(root);
    }
}
