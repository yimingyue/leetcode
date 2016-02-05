package leetcode.BinaryTreeMaximumPathSum;

import ds.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 1/3/16.
 */
public class TestSolution {
    @Test
    public void test0() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(-2);
        root.left = new TreeNode(1);
        assertEquals(new Solution().maxPathSum(root), 1);
    }
}
