package leetcode.SymmetricTree;

import ds.TreeNode;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;

/**
 * Created by ymyue on 1/2/16.
 */
public class TestSolution {
    @Test
    public void test0() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(3);
        root.right.right.left = new TreeNode(4);
        assertFalse(new Solution2().isSymmetric(root));
    }
}
