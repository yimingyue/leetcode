package linkedin.PrintTree;

import ds.TreeNode;
import org.junit.Test;
import utils.BinaryTreeSerialization;

/**
 * Created by ymyue on 10/13/16.
 */
public class TestSolution {
    @Test
    public void test0() {
        TreeNode root = new BinaryTreeSerialization().serializeTreeNode("1,3,5,2,#,4,7,9,6,#,8,#,#");
        new Solution().printTree(root);
    }
}
