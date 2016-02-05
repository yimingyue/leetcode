package leetcode.BalancedBinaryTree;

import ds.TreeNode;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;

/**
 * Created by ymyue on 1/3/16.
 */
public class TestSolution {
    @Test
    public void test0() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        assertFalse(new Solution().isBalanced(root));
    }
}
