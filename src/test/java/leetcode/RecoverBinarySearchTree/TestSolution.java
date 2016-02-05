package leetcode.RecoverBinarySearchTree;

import ds.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 1/2/16.
 */
public class TestSolution {
    @Test
    public void test0() {
        Solution s = new Solution();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        s.recoverTree(root);
        assertEquals(1, root.val);
    }
}
